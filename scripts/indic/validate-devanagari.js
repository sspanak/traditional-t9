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


/**
 * containsInvalidCombination
 * Based on the "do not use sequences" table from here: https://lontar.eu/en/notes/issues-in-devanagari-cluster-validation/
 */
function containsInvalidCombination(word) {
	return /(\u{905}\u{946}|\u{905}\u{93E}|\u{930}\u{94D}\u{907}|\u{909}\u{941}|\u{90F}\u{945}|\u{90F}\u{946}|\u{90F}\u{947}|\u{905}\u{949}|\u{906}\u{945}|\u{905}\u{94A}|\u{906}\u{946}|\u{905}\u{94B}|\u{906}\u{947}|\u{905}\u{94C}|\u{906}\u{948}|\u{905}\u{945}|\u{905}\u{93A}|\u{905}\u{93B}|\u{906}\u{93A}|\u{905}\u{94F}|\u{905}\u{956}|\u{905}\u{957}|\u{916}\u{94D}\u{93E}|\u{916}\u{94D}\u{200D}\u{93E}|\u{917}\u{94D}\u{93E}|\u{917}\u{94D}\u{200D}\u{93E}|\u{918}\u{94D}\u{93E}|\u{918}\u{94D}\u{200D}\u{93E}|\u{91A}\u{94D}\u{93E}|\u{91A}\u{94D}\u{200D}\u{93E}|\u{91C}\u{94D}\u{93E}|\u{91C}\u{94D}\u{200D}\u{93E}|\u{91D}\u{94D}\u{93E}|\u{91D}\u{94D}\u{200D}\u{93E}|\u{91E}\u{94D}\u{93E}|\u{91E}\u{94D}\u{200D}\u{93E}|\u{923}\u{94D}\u{93E}|\u{923}\u{94D}\u{200D}\u{93E}|\u{924}\u{94D}\u{93E}|\u{924}\u{94D}\u{200D}\u{93E}|\u{925}\u{94D}\u{93E}|\u{925}\u{94D}\u{200D}\u{93E}|\u{927}\u{94D}\u{93E}|\u{927}\u{94D}\u{200D}\u{93E}|\u{928}\u{94D}\u{93E}|\u{928}\u{94D}\u{200D}\u{93E}|\u{929}\u{94D}\u{93E}|\u{929}\u{94D}\u{200D}\u{93E}|\u{928}\u{93C}\u{94D}\u{93E}|\u{928}\u{93C}\u{94D}\u{200D}\u{93E}|\u{92A}\u{94D}\u{93E}|\u{92A}\u{94D}\u{200D}\u{93E}|\u{92C}\u{94D}\u{93E}|\u{92C}\u{94D}\u{200D}\u{93E}|\u{92D}\u{94D}\u{93E}|\u{92D}\u{94D}\u{200D}\u{93E}|\u{92E}\u{94D}\u{93E}|\u{92E}\u{94D}\u{200D}\u{93E}|\u{92F}\u{94D}\u{93E}|\u{92F}\u{94D}\u{200D}\u{93E}|\u{932}\u{94D}\u{93E}|\u{932}\u{94D}\u{200D}\u{93E}|\u{935}\u{94D}\u{93E}|\u{935}\u{94D}\u{200D}\u{93E}|\u{936}\u{94D}\u{93E}|\u{936}\u{94D}\u{200D}\u{93E}|\u{937}\u{94D}\u{93E}|\u{937}\u{94D}\u{200D}\u{93E}|\u{938}\u{94D}\u{93E}|\u{938}\u{94D}\u{200D}\u{93E}|\u{959}\u{94D}\u{93E}|\u{959}\u{94D}\u{200D}\u{93E}|\u{916}\u{93C}\u{94D}\u{93E}|\u{916}\u{93C}\u{94D}\u{200D}\u{93E}|\u{95A}\u{94D}\u{93E}|\u{95A}\u{94D}\u{200D}\u{93E}|\u{917}\u{93C}\u{94D}\u{93E}|\u{917}\u{93C}\u{94D}\u{200D}\u{93E}|\u{95B}\u{94D}\u{93E}|\u{95B}\u{94D}\u{200D}\u{93E}|\u{91C}\u{93C}\u{94D}\u{93E}|\u{91C}\u{93C}\u{94D}\u{200D}\u{93E}|\u{95F}\u{94D}\u{93E}|\u{95F}\u{94D}\u{200D}\u{93E}|\u{92F}\u{93C}\u{94D}\u{93E}|\u{92F}\u{93C}\u{94D}\u{200D}\u{93E}|\u{979}\u{94D}\u{93E}|\u{979}\u{94D}\u{200D}\u{93E}|\u{97A}\u{94D}\u{93E}|\u{97A}\u{94D}\u{200D}\u{93E}|\u{97B}\u{94D}\u{93E}|\u{97B}\u{94D}\u{200D}\u{93E}|\u{97C}\u{94D}\u{93E}|\u{97C}\u{94D}\u{200D}\u{93E}|\u{97E}\u{94D}\u{93E}|\u{97E}\u{94D}\u{200D}\u{93E}|\u{97F}\u{94D}\u{93E}|\u{97F}\u{94D}\u{200D}\u{93E}|\u{915}\u{94D}\u{91A}\u{94D}\u{93E}|\u{915}\u{94D}\u{91A}\u{94D}\u{200D}\u{93E}|\u{915}\u{94D}\u{937}\u{94D}\u{93E}|\u{915}\u{94D}\u{937}\u{94D}\u{200D}\u{93E}|\u{924}\u{94D}\u{924}\u{94D}\u{93E}|\u{924}\u{94D}\u{924}\u{94D}\u{200D}\u{93E}|\u{928}\u{94D}\u{924}\u{94D}\u{93E}|\u{928}\u{94D}\u{924}\u{94D}\u{200D}\u{93E})/u
		.test(word);
}


function containsVowelMatra(word) {
	return /[\u{905}-\u{90C}\u{90F}\u{910}\u{913}\u{914}\u{960}\u{961}][\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}]/u.test(word);
}


function containsConsonantHalantMatra(word) {
	return /[\u0915-\u0939\u0958-\u095F]\u094D[\u093E-\u094C\u0962-\u0963]/u.test(word);
}


function containsInvalidZWJ(word) {
	return /[\u0900-\u0903\u0904\u0905-\u0914\u093E-\u094C\u0962-\u0963\u093D]\u200D/u.test(word);
}


function containsMultipleNasalizations(word) {
	return /[\u{900}\u{901}\u{902}\u{903}]{2,}/u.test(word);
}


function containsMultipleMatraNasalizations(word) {
	return /([\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}][\u{900}\u{901}\u{902}\u{903}]|[\u{900}\u{901}\u{902}\u{903}][\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}])[\u{900}\u{901}\u{902}\u{903}\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}]/u
		.test(word);
}

function containsModifierMatra(word) {
    return /[\u{900}-\u{903}\u{94d}][\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}]/u.test(word);
}


function containsTooManyRepeatedLetters(word) {
	return /(.)\1{2,}/.test(word);
}


function containsForeignLetters(word) {
	return /[\u{944}ऑऍऎऒॠ]+[\u{900}-\u{903}\u{94d}\u{93E}-\u{944}\u{947}\u{948}\u{94B}\u{94C}\u{962}\u{963}]?/u.test(word);
}


function fixNuqta(word) {
	return word.replaceAll('ऴ', '\u{933}\u{93c}');
}


/**
 * isValid
 *
 * Most validation rules are based on the comments here: https://github.com/harfbuzz/harfbuzz/issues/2803.
 */
function isValid(word) {
	return !containsInvalidCombination(word)
		&& !containsVowelMatra(word)
		&& !containsConsonantHalantMatra(word)
		&& !containsInvalidZWJ(word)
		&& !containsMultipleNasalizations(word)
		&& !containsMultipleMatraNasalizations(word)
		&& !containsModifierMatra(word)
		&& !containsTooManyRepeatedLetters(word)
		&& !containsForeignLetters(word)
}


function work({ file }) {
	Array.from(getWordsFromFile(file)).forEach(w => {
		if (isValid(w)) print(fixNuqta(w));
	});
}

work(validateInput());
