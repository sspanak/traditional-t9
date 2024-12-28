const { basename } = require('path');
const { existsSync, readFileSync } = require('fs');
const { print, printError, printWordsWithFrequencies } = require('../_printers.js');


function printHelp() {
	print(`Usage: node ${basename(process.argv[1])} <file>`);
}


function validateInput() {
	if (process.argv.length < 3) {
		printHelp();
		process.exit(1);
	}

	if (!existsSync(process.argv[2])) {
		printError(`Failure! Could not find the input file "${process.argv[2]}".`);
		process.exit(2);
	}

	return { file: process.argv[2] };
}


function getWordsFromFile(filename) {
	const content = readFileSync(filename, 'utf8');
	return new Set(content.split('\n').map(word => word.trim()).filter(word => word.length > 0));
}

const FOREIGN_CHARS = '[^\\u{A80}-\\u{AFF}]';
const UNWANTED_CHARS = 'ૠ\\u{AC4}\\u{AE3}-\\u{AFF}\\u{AD1}-\\u{ADF}\\u{A80}\\u{A84}\\u{A8E}\\u{A92}\\u{AA9}\\u{AB1}\\u{AB4}\\u{ABA}\\u{ABB}\\u{AC6}\\u{ACA}\\u{ACE}\\u{ACF}';
const NUMBERS = '\\u{0AE6}-\\u{0AEF}';
const VOWELS = '\\u{0A85}-\\u{0A94}\\u{0AE0}\\u{0AE1}ૐ';
const CONSONANTS = '\\u{0A95}-\\u{0AB9}';
const VOWEL_MATRAS = '\\u{0ABE}-\\u{0AC5}\\u{0AC7}-\\u{0AC9}\\u{0ACB}-\\u{0ACC}\\u{0AE2}\\u{0AE3}';
const NASALIZATIONS = '\\u{0A81}-\\u{0A83}';
const HALANT = '\\u{0ACD}';
const NUQTA = '\\u{0ABC}';
const AVAGRAHA = '\\u{0ABD}';
const ZWJ = '\\u{200D}';


const INVALIDATORS = [
    (word) => new RegExp(`(\\p{L}\\p{M}?)(?!${AVAGRAHA})\\1{2,}`, 'u').test(word), // too many repeated letters
    (word) => new RegExp(`^[${VOWEL_MATRAS}${NASALIZATIONS}${HALANT}${NUQTA}${AVAGRAHA}]`, 'u').test(word), // starts with a combining character
    (word) => new RegExp(`[${VOWELS}][${VOWEL_MATRAS}${NUQTA}${HALANT}]`, 'u').test(word),
    (word) => new RegExp(`[${CONSONANTS}]${HALANT}[${VOWEL_MATRAS}]`, 'u').test(word),
    (word) => new RegExp(`[${NASALIZATIONS}${VOWELS}${VOWEL_MATRAS}${AVAGRAHA}]${ZWJ}`, 'u').test(word), // invalid ZWJ
    (word) => new RegExp(`([${VOWEL_MATRAS}]{2}|[${NASALIZATIONS}]{2}|${HALANT}{2}|${NUQTA}{2})`, 'u').test(word), // multiple combining
    (word) => new RegExp(`([${VOWEL_MATRAS}][${NASALIZATIONS}]|[${NASALIZATIONS}][${VOWEL_MATRAS}])[${VOWEL_MATRAS}${NASALIZATIONS}]`, 'u').test(word), // multiple matra nasalizations
    (word) => new RegExp(`[${NASALIZATIONS}${HALANT}][${VOWEL_MATRAS}]`, 'u').test(word), // modifier + matra
    (word) => new RegExp(`[^${CONSONANTS}][${NUQTA}]`, 'u').test(word), // non-consonant + nukta
    (word) => new RegExp(`[${UNWANTED_CHARS}]`, 'u').test(word),
    (word) => new RegExp(`${FOREIGN_CHARS}`, 'u').test(word),
    (word) => new RegExp(`[${NUMBERS}]`, 'u').test(word),
];


/**
 * isValid
 *
 * Most validation rules are based on the comments here: https://github.com/harfbuzz/harfbuzz/issues/2803.
 */
function isValid(word) {
    for (let i = 0; i < INVALIDATORS.length; i++) {
        if (INVALIDATORS[i](word)) {
            return false;
        }
    }

	return true;
}


function fixNuqta(word) {
//	return word.replaceAll('ऴ', '\u{933}\u{93c}');
    return word;
}


function getWordsWithObsoleteCandrabinduInGujarati(allWords) {
    const allWordsAnusvara = new Set();
	allWords.forEach(w => {
	    const converted = w.replaceAll('\u{A81}', '\u{A82}');
	    if (converted !== w) {
	        allWordsAnusvara.add(converted);
        }
	});

	return allWordsAnusvara;
}


function work({ file }) {
    const allWords = Array.from(getWordsFromFile(file));

    // Detect obsolete candrabindu instead of anusvara in Gujarati
	const allWordsAnusvara = getWordsWithObsoleteCandrabinduInGujarati(allWords);

	allWords.forEach(w => {
	    const word = allWordsAnusvara.has(w) ? w.replaceAll('\u{A81}', '\u{A82}') : w;
		if (isValid(word)) print(fixNuqta(word));
	});
}

work(validateInput());
