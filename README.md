# Traditional T9
TT9 is an IME (Input Method Editor) for Android devices with a hardware keypad. It supports predictive text typing in [multiple languages](languages/definitions) and configurable hotkeys, bringing old school Nokia experience to modern Android devices.

This is a modernized version of the [original project](https://github.com/Clam-/TraditionalT9) by Clam-.

[<img src="https://gitlab.com/IzzyOnDroid/repo/-/raw/master/assets/IzzyOnDroid.png"
     alt="Get it on IzzyOnDroid"
     height="80">](https://apt.izzysoft.de/fdroid/index/apk/io.github.sspanak.tt9)

or get the APK from the [Releases Section](https://github.com/sspanak/tt9/releases/latest).

## Screenshots
<img src="screenshots/1.png" width="160" height="177"> <img src="screenshots/3.png" width="160" height="177"> <img src="screenshots/5.png" width="160" height="177">
<img src="screenshots/2.png" width="160" height="177"> <img src="screenshots/4.png" width="160" height="177">

## System Requirements
- Android 4.4 or higher. _(Tested and confirmed on Android 6.0, 10 and 11)_
- A hardware keypad or a keyboard. For touchscreen-only devices, an on-screen keypad can be enabled in the Settings.
- Minimum 50 Mb of storage space. Extra space is needed for language dictionaries in Predictive Mode.
    - Very small languages (< 100k words; Yiddish, Indonesian): 5-6 Mb per language.
    - Small languages (100k-400k words; e.g. English, Norwegian, Swedish, Finnish, German, French): 15-30 Mb per language.
    - Medium languages (400k-800k words; e.g. Danish, Hebrew, Italian, Greek): 40-75 Mb per language
    - Large languages (800k-1.5M words; e.g. Bulgarian, Spanish, Romanian, Ukrainian, Russian): 100-165 Mb per language

_Storage usage depends on the word roots count, and the average word length in each language. Some languages will require more space, even if they have less words than others._

### Compatibility
If you own a phone with Android 2.2 up to 4.4, please refer to the original version of Traditional T9 from 2016.

TT9 may not work well on Kyocera phones, some Sonim phones and some other devices that run highly customized Android versions, where all apps are integrated and intended to work with the respective native keyboard. You may experience missing functionality or unexpected text/numbers appearing when you try to type.

## How to Use Traditional T9?
Before using Traditional T9 for the first time you would need to load a dictionary and configure it. After that, you could start typing right away in one of the three modes: Predictive, ABC or Numeric (123). And even if you have mastered the keypad back in the days, you would still find the Predictive mode now provides powerful and smart new ways of typing with even less key presses.

So make sure to read the initial setup and the hotkey tips in the [user manual](docs/user-manual.md).

## Contributing to the Project
As with many other open-source projects, this one is also maintained by its author in his free time. Any help in making Traditional T9 better will be highly appreciated. Here is how:
- Add [a new language](CONTRIBUTING.md#adding-a-new-language), [new UI translations](CONTRIBUTING.md#translating-the-ui) or simply fix a spelling mistake. The process is very simple and even with minimum technical knowledge, your skills as a native speaker will be of great use. Or, if you are not tech-savvy, just [open a new issue](https://github.com/sspanak/tt9/issues) and put the correct translations or words there. Correcting misspelled words or adding new ones is the best you can do to help. Processing millions of words in multiple languages is a very difficult task for a single person.
- [Report bugs](https://github.com/sspanak/tt9/issues) or other unusual behavior on different phones. Currently, the only testing and development devices are: Qin F21 Pro+ / Android 11; Energizer H620SEU / Android 10; Vodaphone VFD 500 / Android 6.0. But Android behaviour and appearance varies a lot across the millions of devices available out there.
- Experienced developers who are willing fix a bug, or maybe create a brand new feature, see the [Contribution Guide](CONTRIBUTING.md).

Your PRs are welcome!

## Supporting the Project
If you like Traditional T9, buy me a beer. Donations are currently accepted on [buymeacoffee.com](https://www.buymeacoffee.com/sspanak).

## License
- The source code, the logo image and the icons are licensed under the conditions described in [LICENSE.txt](LICENSE.txt).
- The dictionaries are licensed under the licenses provided in the [respective readme files](docs/dictionaries), where applicable. Detailed information about the dictionaries is also available there.
- [Silver foil photo created by rawpixel.com - www.freepik.com](https://www.freepik.com/photos/silver-foil)
- "Negotiate" and "Vibrocentric" fonts are under [The Fontspring Desktop/Ebook Font End User License](docs/desktop-ebook-EULA-1.8.txt).

## Privacy Policy and Philosophy
- No ads.
- No spying, no tracking, no telemetry or reports. No nothing!
- No network connectivity.
- It only does its job.
- Open-source, so you verify all the above yourself.
- Created with help from the entire community.