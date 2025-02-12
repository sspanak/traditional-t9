# Traditional T9
This manual explains how to configure and use Traditional T9 in different scenarios. For installation instructions and information about the "lite" and "full" versions, please consult the [Installation Guide](https://github.com/sspanak/tt9/blob/master/docs/installation.md) on GitHub. Finally, you may want to check out the [main repository page](https://github.com/sspanak/tt9), which includes all source code, a developer's guide, the privacy policy, and supplementary documentation.

## Initial Setup
After installing, first, you need to enable Traditional T9 as an Android keyboard. To do so, click on the launcher icon. If you need to take any action, all options besides Initial Setup will be disabled, and there will be a label: "TT9 is disabled". Go to Initial Setup and enable it.

_If you don't see the icon right after installing, restart your phone, and it should appear. It is due to Android trying to save some battery life by not refreshing the newly installed apps list._

### Using on a touchscreen-only phone
On touchscreen devices, it is also highly recommended to disable the system spell checker. It can not be used when typing with the number keys, so you can save some battery life by disabling it.

Another problem is, that it may show a confusing "Add Word" popup dialog, which adds words to the default system keyboard (usually, Gboard) and not to Traditional T9's dictionary. Again, to avoid such situations, the system spell checker must be disabled.

If you need to perform this step, the "System Spell Checker" item on the Initial Setup screen will be active. Click it to disable the system component. If you there is no such item, then you don't need to do anything else.

After you are done with the setup, check out the [On-screen Keypad section](#on-screen-keypad) for more tips and tricks.

### Enabling Predictive Mode
Predictive Mode requires a language dictionary to be loaded to provide word suggestions. You can toggle the enabled languages and load their dictionaries from Settings Screen → [Languages](#language-options). In case, you have forgotten to load some dictionary, Traditional T9 will do it for you automatically when you start typing. For more information, [see below](#language-options).

#### Notes for low-end phones
Dictionary loading may saturate low-end phones. When using the TT9 "lite" version, this will cause Android to abort the operation. If loading takes more than 30 seconds, plug in the charger or ensure the screen stays on during loading.

You can avoid the above by using the "full" version instead.

#### Notes for Android 13 or higher
By default, the notifications for newly installed apps are disabled. It is recommended to enable them. This way you will get notified when there are dictionary updates, and once you choose to install them, TT9 will show the loading progress. New updates are released at most once a month, so you don't have to worry about getting too much spam.

You can enable the notifications by going to Settings → Languages and toggling Dictionary Notifications.

_If you decide to keep them off, TT9 will continue to work without problems, but you will have to manage the dictionaries manually._

## Hotkeys

All hotkeys can be reconfigured or disabled from Settings → Keypad → Select Hotkeys.

### Typing Keys

#### Previous Suggestion key (Default: D-pad Left):
Select the previous word/letter suggestion.

#### Next Suggestion key (Default: D-pad Right):
Select the next word/letter suggestion.

#### Filter Suggestions key (Default: D-pad Up):
_Predictive mode only._

- **Single press**: Filter the suggestion list, leaving out only the ones that start with the current word. It doesn't matter if it is a complete word or not. For example, type "remin" and press Filter. It will leave out all words starting with "remin": "remin" itself, "remind", "reminds", "reminded", "reminding", and so on.
- **Double press**: Expand the filter to the full suggestion. For example, type "remin" and press Filter twice. It will first filter by "remin", then expand the filter to "remind". You can keep expanding the filter until you get to the longest dictionary word.

Filtering is also useful for typing unknown words. Let's say you want to type "Anakin", which is not in the dictionary. Start with "A", then press Filter to hide "B" and "C". Now press 6-key. Since the filter is on, in addition to the real dictionary words, it will provide all possible combinations for 1+6: "A..." + "m", "n", "o". Select "n" and press Filter to confirm your selection and produce "An". Now pressing the 2-key, will provide "An..." + "a", "b", and "c". Select "a", and keep going, until you get "Anakin".

When filtering is enabled, the base text will become bold and italicized.

#### Clear Filter key (Default: D-pad Down):
_Predictive mode only._

Clear the suggestion filter, if applied.

#### D-pad Center (OK or ENTER):
- When suggestions are displayed, type the currently selected suggestion.
- Otherwise, perform the default action for the current application (e.g. send a message, go to a URL, or just type a new line).

_**Note:** Every application decides on its own what to do when OK is pressed and TT9 has no control over this._

_**Note 2:** To send messages with OK in messaging applications, you must enable their "Send with ENTER" or similarly named setting. If the application has no such setting, it probably does not support sending messages this way. If so, use the KeyMapper app from the [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) or from [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). It can detect chat apps and simulate a touch on the send message button upon pressing or holding a hardware key. Check out the [quick-start guide](https://docs.keymapper.club/quick-start/) for more info._

#### 0-key:
- **In 123 mode:**
  - **Press:** type "0".
  - **Hold:** type special/math characters.
  - **Hold "0", then press Shift (Default: hold "0", press "✱"):** type currency characters.
- **In ABC mode:**
  - **Press:** type space, newline, or special/math characters.
  - **Hold:** type "0".
  - **Press "0", then press Shift (Default: press "0", "✱"):** type currency characters.
- **In Predictive mode:**
  - **Press:** type space, newline, or special/math characters.
  - **Double press:** type the character assigned in Predictive mode settings. (Default: ".")
  - **Hold:** type "0".
  - **Press "0", then press Shift (Default: press "0", "✱"):** type currency characters.
- **In Cheonjiin mode (Korean):**
  - **Press:** type "ㅇ" and "ㅁ".
  - **Hold:** type space, newline, 0, or special/math characters.
  - **Hold "0", then press Shift (Default: hold "0", press "✱"):** type currency characters.

#### 1-key:
- **In 123 mode:**
  - **Press:** type "1".
  - **Hold:** type sentence characters.
- **In ABC mode:**
  - **Press:** type sentence characters.
  - **Hold:** type "1".
- **In Predictive mode:**
  - **Press:** type punctuation and sentence characters.
  - **Press multiple times:** type emoji.
  - **Press 1-1-3:** type custom added emoji (you must have added some using [the Add Word key](#add-word-key)).
  - **Hold:** type "1".
- **In Cheonjiin mode (Korean):**
  - **Press:** type the "ㅣ" vowel.
  - **Hold:** type punctuation and sentence characters.
  - **Hold, then press:** type emoji.
  - **Hold 1, press 1, press 3:** type custom added emoji (you must have added some using [the Add Word key](#add-word-key)).

#### 2- to 9-key:
- **In 123 mode:** type the respective number.
- **In ABC and Predictive mode:** type a letter or hold to type the respective number.

### Function Keys

#### Add Word Key:
Add a new word to the dictionary for the current language.

You can also add new emojis and then access them by pressing 1-1-3. Regardless of the currently selected language, all emojis will be available in all languages.

#### Backspace Key (Back, Del, or Backspace):
Just deletes text.

If your phone has a dedicated "Del" or "Clear" key, you do not need to set anything in the Settings, unless you want to have another Backspace. In this case, the blank option: "--" will be automatically preselected.

On phones which have a combined "Delete"/"Back", that key will be selected automatically. However, you can assign the "Backspace" function to another key, so "Back" will only navigate back.

_**NB:** Using "Back" as backspace does not work in all applications, most notably Firefox, Spotify, and Termux. They can take full control of the key and redefine its function, meaning it will do whatever the app authors intended. Unfortunately, nothing can be done, because "Back" plays a special role in Android and its usage is restricted by the system._

_**NB 2:** Holding the "Back" key will always trigger the default system action (i.e. show the running applications list)._

_In these cases, you could assign another key (all other keys are fully usable), or use the on-screen backspace._

#### Next Input Mode Key (Default: press #):
Cycle the input modes (abc → Predictive → 123).

_Predictive mode is not available in password fields._

_In number-only fields, changing the mode is not possible. In such cases, the key reverts to its default function (i.e. type "#")._

#### Edit Text Key:
Show the text editing panel, which allows you to select, cut, copy, and paste text. You can close the panel by pressing the "✱" key again or, in most applications, by pressing the Back button. Details are available [below](#text-editing).

#### Next Language Key (Default: hold #):
Select the next language, when multiple languages have been enabled from the Settings.

#### Select Keyboard Key:
Open the Android Change Keyboard dialog where you can select between all installed keyboards.

#### Shift Key (Default: press ✱):
- **When typing text:** Toggle between uppercase and lowercase.
- **When typing special characters with the 0-key**: Display the next character group.

#### Show Settings Key:
Open the Settings configuration screen. It is where you can choose languages for typing, configure the keypad hotkeys, change the application appearance, or improve compatibility with your phone.

#### Voice Input Key:
Activate the voice input on the phones that support it. See [below](#voice-input) for more info.

#### Command-List Key / aka Command Palette / (Default: hold ✱):
Show a list of all commands (or functions).

Many phones have only two or three "free" buttons that can be used as hotkeys. But, Traditional T9 has many more functions, meaning there is simply no room for all of them on the keypad. The Command Palette resolves this problem. It allows invoking the additional functions (or commands) using key combos.

Below is a list of the possible commands:
- **Show the Settings Screen (Default Combo: hold ✱, 1-key).** Same as pressing [Show Settings](#show-settings-key).
- **Add a Word (Default Combo: hold ✱, 2-key).** Same as pressing [Add Word](#add-word-key).
- **Voice Input (Default Combo: hold ✱, 3-key).** Same as pressing [Voice Input](#voice-input-key).
- **Edit Text (Default Combo: hold ✱, 5-key).** Same as pressing [Edit Text](#edit-text-key)
- **Select a Different Keyboard (Default Combo: hold ✱, 8-key).** Same as pressing [Select Keyboard](#select-keyboard-key).

_This key does not do anything when the Screen Layout is set to "Virtual Keypad" because all keys for all possible functions are already available on the screen._

## Voice Input
The voice input function allows for speech-to-text input, similar to Gboard. Like all other keyboards, Traditional T9 does not perform speech recognition by itself, but it asks your phone to do it.

_The Voice Input button is hidden on devices that do not support it._

### Supported Devices
On devices with Google Services, it will use the Google Cloud infrastructure to convert your words to text. You must connect to a Wi-Fi network or enable mobile data for this method to work.

On devices without Google, if the device has a voice assistant app or the native keyboard supports voice input, whichever is available will be used for speech recognition. Note that this method is considerably less capable than Google. It will not work in a noisy environment and will usually recognize only simple phrases, such as: "open calendar" or "play music" and similar. The advantage is that it will work offline.

Other phones without Google will generally not support voice input. Chinese phones do not have speech recognition capabilities due to Chinese security policies. On these phones, it may be possible to enable voice input support by installing the Google application, package name: "com.google.android.googlequicksearchbox".

## On-screen Keypad
On touchscreen-only phones, a fully functional on-screen keypad is available and it will be enabled automatically. If, for some reason, your phone was not detected to have a touchscreen, enable it by going to Settings → Appearance → On-Screen Layout, and selecting "Virtual Numpad".

If you do have both a touchscreen and a hardware keypad and prefer having more screen space, disable the software keys from Settings → Appearance.

It is also recommended to disable the special behavior of the "Back" key working as "Backspace". It is useful only for a hardware keypad. Usually, it will happen automatically too, but if it does not, go to Settings → Keypad → Select Hotkeys → Backspace key, then select the "--" option.

### Virtual Keys Overview
The on-screen keypad works the same as the numpad of a phone with hardware keys. If a key provides a single function, it has one label (or icon) indicating that function. If the key provides a secondary "hold" function, it will have two labels (or icons).

Below is a description of the keys with more than one function.

#### Right F2 key (the second key from the top in the right column)
_Predictive mode only._

- **Press:** Filter the suggestion list. See [above](#filter-suggestions-key-default-d-pad-up) how word filtering works.
- **Hold:** Clear the filter, if active.

#### Right F3 key (the third key from the top in the right column)
- **Press:** Open the copy-pasting and text editing options.
- **Hold:** Activate the Voice Input.

#### Left F4 key (located above "OK")
- **Press:** Cycle the input modes (abc → Predictive → 123).
- **Hold:** Select the next language, when multiple languages have been enabled from the Settings.
- **Horizontal swipe:** Switch to the last used keyboard, other than TT9.
- **Vertical swipe:** Open the Android Change Keyboard dialog where you can select between all installed keyboards.

_The key will display a small globe icon when you have enabled multiple languages from Settings -> Languages. The icon indicates it is possible to change the language by holding the key._

### Resizing the Keyboard Panel While Typing
In some cases, you may find that the Virtual Keypad is taking up too much screen space, preventing you from seeing what you are typing or some application elements. If so, you can resize it by either holding and dragging the Settings/Command Palette key or by dragging the Status Bar (it is where the current language or typing mode is displayed). When the height becomes too small, the layout will automatically be switched to "Function keys" or "Suggestion list only". Respectively, when resizing up, the layout will change to "Virtual Keypad". You can also double-tap the status bar to minimize or maximize instantly.

_Resizing Traditional T9 also results in resizing the current application. Doing both is computationally very expensive. It may cause flickering or stuttering on many phones, even higher-end ones._

### Changing the Key Height
It is also possible to change the on-screen key height. To do so, go to Settings → Appearance → On-screen Key Height and adjust it as desired.

The default setting of 100% is a good balance between usable button size and screen space taken. However, if you have large fingers, you may want to increase the setting a bit, while if you use TT9 on a larger screen, like a tablet, you may want to decrease it.

_If the available screen space is limited, TT9 will ignore this setting and reduce its height automatically, to leave enough room for the current application._

## Text Editing
From the Text Editing panel, you can select, cut, copy, and paste text, similar to what is possible with a computer keyboard. To exit Text Editing, press the "✱" key, or the Back key (except in web browsers, Spotify, and a few more applications). Or press the letters key on the On-screen Keyboard.

Below is a list of the possible text commands:
1. Select the previous character (like Shift+Left on a computer keyboard)
2. Select none
3. Select the next character (like Shift+Right)
4. Select the previous word (like Ctrl+Shift+Left)
5. Select all
6. Select the next word (like Ctrl+Shift+Right)
7. Cut
8. Copy
9. Paste

For easier editing, backspace, space, and OK keys are also active.

## Settings Screen
On the Settings screen, you can choose languages for typing, configure the keypad hotkeys, change the application appearance, or improve compatibility with your phone.

### How to access the Settings?

#### Method 1
Click on the Traditional T9 launcher icon.

#### Method 2 (using a touchscreen)
- Tap on a text or a number field to wake up TT9.
- Use the on-screen gear button.

#### Method 3 (using a physical keyboard)
- Start typing in a text or a number field to wake up TT9.
- Open the commands list using the on-screen tools button or by pressing the assigned hotkey [Default: Hold ✱].
- Press the 2-key.

### Navigating Around the Settings
If you have a device with a hardware keypad, there are two ways of navigating around the Settings.

1. Use the Up/Down keys for scrolling and OK for opening or activating an option.
2. Press the 1-9 keys to select the respective option and double-press them to open/activate it. Double-pressing will work no matter where you are on the screen. For example, even if you are at the top double-pressing the 3-key will activate the third option. Finally, the 0-key is a convenient shortcut for scrolling to the end but does not open the last option.

### Language Options

#### Loading a Dictionary
After enabling one or more new languages, you must load the respective dictionaries for Predictive Mode. Once a dictionary is loaded, it will stay there until you use one of the "delete" options. This means you can enable and disable languages without reloading their dictionaries every time. Just do it once, only the first time.

It also means that if you need to start using language X, you can safely disable all other languages, load only dictionary X (and save time!), and then re-enable all languages you used before.

Have in mind reloading a dictionary will reset the suggestion popularity to the factory defaults. However, there should be nothing to worry about. For the most part, you will see little to no difference in the suggestion order, unless you often use uncommon words.

#### Automatic Dictionary Loading

If you skip or forget to load a dictionary from the Settings screen, it will happen automatically later, when you go to an application where you can type, and switch to Predictive Mode. You will be prompted to wait until it completes and after that, you can start typing right away.

If you delete one or more dictionaries, they will NOT reload automatically. You will have to do so manually. Only dictionaries for newly enabled languages will load automatically.

#### Deleting a Dictionary
If you have stopped using languages X or Y, you could disable them and also use "Delete Unselected", to free some storage space.

To delete everything, regardless of the selection, use "Delete All".

In all cases, your custom-added words will be preserved and restored once you reload the respective dictionary.

#### Added Words
The "Export" option allows you to export all added words, for all languages, including any added emoji, to a CSV file. Then, you can use the CSV file to make Traditional T9 better! Go to GitHub and share the words in a [new issue](https://github.com/sspanak/tt9/issues) or [pull request](https://github.com/sspanak/tt9/pulls). After being reviewed and approved, they will be included in the next version.

With "Import", you can import a previously exported CSV. However, there are some restrictions:
- You can import only words consisting of letters. Apostrophes, dashes, other punctuation, or special characters are not allowed.
- Emojis are not allowed.
- One CSV file can contain a maximum of 250 words.
- You can import up to 1000 words, meaning you can import at most 4 files X 250 words. Beyond that limit, you can still add words while typing.

Using "Delete", you can search for and delete misspelled words or others that you don't want in the dictionary.

### Compatibility Options
For several applications or devices, it is possible to enable special options, which will make Traditional T9 work better with them. You can find them at the end of each settings screen, under the Compatibility section.

#### Alternative suggestion scrolling method
_In: Settings → Appearance._

On some devices, in Predictive Mode, you may not be able may not be able to scroll the list to the end, or you may need to scroll backward and forward several times until the last suggestion appears. The problem occurs sometimes on Android 9 or earlier. Enable the option, if you are experiencing this issue.

#### Always on top
_In: Settings → Appearance._

On some phones, especially Sonim XP3plus (XP3900), Traditional T9 may not appear when you start to type, or it may be partially covered by the soft keys. In other cases, there may be white bars around it. The problem may occur in one particular application or all of them. To prevent it, enable the "Always on Top" option.

#### Key repeat protection
_In: Settings → Keypad._

CAT S22 Flip and Qin F21 phones are known for their low-quality keypads, which degrade quickly over time and start registering multiple clicks for a single key press. You may notice this when typing or navigating the phone menus.

For CAT phones the recommended setting is 50-75 ms. For Qin F21, try with 20-30 ms. If you are still experiencing the issue, increase the value a bit, but generally try to keep it as low as possible.


_**Note:** The higher the value you set, the slower you will have to type. TT9 will ignore very quick key presses._

_**Note 2:** Besides the above, Qin phones may also fail to detect long presses. Unfortunately, in this case, nothing can be done._

#### Telegram/Snapchat stickers and emoji panels won't open
This happens if you are using one of the small-sized layouts. Currently, there is no permanent fix, but you can use the following workaround:
- Go to Settings → Appearance and enable On-Screen Numpad.
- Go back to the chat and click the emoji or the stickers button. They will now appear.
- You can now go back to the settings and disable the on-screen numpad. The emoji and sticker panels will remain accessible until you restart the app or the phone.

#### Traditional T9 does not appear immediately in some applications
If you have opened an application where you can type, but TT9 does not appear automatically, just start typing and it will. Alternatively, pressing the hotkeys to change [the input mode](#next-input-mode-key-default-press-) or the [language](#next-language-key-default-hold-) can also bring up TT9, when it is hidden.

On some devices, TT9 may remain invisible, no matter what you do. In such cases, you have to enable [Always on Top](#always-on-top).

**Long explanation.** The reason for this problem is Android is primarily designed for touchscreen devices. Hence, it expects you to touch the text/number field to show the keyboard. It is possible to make TT9 appear without this confirmation, but then, in some cases, Android will forget to hide it when it must. For example, it may remain visible after you have dialed a phone number or after you have submitted text in a search field.

For these reasons, to stick with the expected Android standards, the control is in your hands. Just press a key to "touch" the screen and keep typing.

#### On the Qin F21 Pro, holding 2-key or 8-key turns up or down the volume instead of typing a number
To mitigate this problem, go to Settings → Appearance, and enable "Status Icon". TT9 should detect Qin F21 and enable the settings automatically, but in case auto-detection fails, or you have disabled the icon for some reason, you need to have it enabled, for all keys to work properly.

**Long explanation.** Qin F21 Pro (and possibly F22, too), has a hotkey application that allows assigning Volume Up and Volume Down functions to number keys. By default, the hotkey manager is enabled, and holding 2-key increases the volume, holding 8-key decreases it. However, when there is no status icon, the manager assumes no keyboard is active and adjusts the volume, instead of letting Traditional T9 handle the key and type a number. So, enabling the icon just bypasses the hotkey manager and everything works fine.

#### General problems on Xiaomi phones
Xiaomi has introduced several non-standard permissions on their phones, which prevent Traditional T9's virtual on-screen keyboard from working properly. More precisely, the "Show Settings" and the "Add Word" keys may not perform their respective functions. To fix this, you must grant the "Display pop-up window" and "Display pop-up window while running in the background" permissions to TT9 from your phone's settings. [This guide](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) for another application explains how to do it.

It is also highly recommended to grant the "Permanent notification" permission. This is similar to the "Notifications" permission introduced in Android 13. See [above](#notes-for-android-13-or-higher) for more information on why you need it.

_The Xiaomi problems have been discussed in [this GitHub issue](https://github.com/sspanak/tt9/issues/490)._

#### Voice Input takes a very long time to stop
It is [a known problem](https://issuetracker.google.com/issues/158198432) on Android 10 that Google never fixed. It is not possible to mitigate it on the TT9 side. To stop the Voice Input operation, stay quiet for a couple of seconds. Android turns off the microphone automatically when it can not detect any speech.

## Frequently Asked Questions

#### Can't you add feature X?
No.

Everyone has their preferences. Some want larger keys, some in a different order, some want a shortcut key for typing ".com," and some miss their old phone or keyboard. But please understand that I am doing voluntary work in my free time. It is impossible to fulfill thousands of different wishes, some of which contradict each other.

Henry Ford once said, "It can be any color the customer wants, as long as it is black." Similarly, Traditional T9 is unadorned, effective, and free but you get what you get.

#### Can't you make it more similar to Sony Ericsson or Xperia, Nokia C2, Samsung, some other software keyboard, etc?
No.

Traditional T9 is not meant to be a replacement or a clone app. It has its own unique design, inspired mainly by the Nokia 3310 and 6303i. And while it captures the feel of the classics, it provides its own experience that won’t replicate any device exactly.

#### You should copy Touchpal, it's the greatest keyboard in the world!
No, I should not. See the previous points.

Touchpal used to be the greatest keyboard back in 2015 when it had no real competition. However, things have changed since then. See the side-by-side comparison between Traditional T9 and Touchpal:

_**Traditional T9**_
- Respects your privacy.
- Contains no ads and it's free.
- Supports a wide range of devices: dumbphones and TVs with hardware keypads or keyboards, as well as touchscreen-only smartphones and tablets.
- Offers a proper 12-key T9 layout for every language.
- Provides enhanced word suggestions. For example, if you try to type textonym expressions like "go in", it will learn not to suggest "go go" or "in in", but the meaningful expression you had in mind.
- Everything you type remains on your phone. No information is sent anywhere.
- Is open source, allowing you to review all the source code and the dictionaries, or contribute to the project and make it better (many users have helped with fixing bugs and adding new languages and translations), or even create a mod based on your preferences and vision.
- Has a clean and highly readable design that blends with the system. There are no unnecessary bells and whistles so that you can focus on typing.
- Dictionary loading speed is slow.

_**Touchpal**_
- Aggressively asks for access to your entire device and to your contacts; writes random files everywhere; ultimately, it got banned from the Play Store because it acts like a virus.
- Is full of ads.
- Supports only touchscreen devices.
- Is not a true T9 keyboard. It offers a T9 layout only in some languages. Moreover, some layouts are incorrect (e.g. Bulgarian is missing a letter and some letters are wrongly swapped between the 8-key and the 9-key).
- When typing textonyms one after another, it only suggests the last word you selected. For example, when you try to type "go in", it will display either "go go" or "in in".
- Cloud-based suggestions could be used to improve accuracy. However, for this to work, you and all other users must send everything you type to the Touchpal servers for processing.
- Closed source. There is no way to check what it does in the background.
- Includes many themes, colors, GIFs, and other distractions unrelated to typing.
- Dictionary loading speed is fast. Touchpal wins this point.

If you disagree or would like to explain your point of view, join [the open discussion](https://github.com/sspanak/tt9/issues/647) on GitHub. Just remember to be respectful to the others. Hate posts will not be tolerated.

#### I need to use a QWERTY layout (touchscreen devices only)
Traditional T9 is a T9 keyboard and as such, it does not provide a QWERTY-like layout.

If you are still learning to use T9 and need to switch back occasionally or find it more convenient to type new words using QWERTY, swipe up the Left F4 key to switch to a different keyboard. See the [virtual keys overview](#virtual-keys-overview) for more information.

Most other keyboards allow switching back to Traditional T9 by holding the spacebar or the "change language" key. Check the respective readme or manual for more info.

#### I can't change the language on a touchscreen phone
First, ensure you have enabled all desired languages from Settings → Languages. Then hold the [Left F4 key](#left-f4-key-located-above-ok) to change the language.