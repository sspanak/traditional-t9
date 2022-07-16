# Traditional T9
TT9 is an IME (Input Method Editor) for Android devices with hardware keypad. It supports multiple languages and predictive text typing. _NOTE: TT9 is not usable on touchscreen-only devices._

## Initial Setup
TODO: Initial config, loading a dictionary...

## Hotkeys
#### D-pad Up (↑):
Select previous word suggestion

#### D-pad Down (↓):
Select next word suggestion

#### Left Soft Key:
Insert symbol or Add word depending on state and context. Add word only available in Predictive input mode.

#### Right Soft Key:
- **Short press:** Cycle input modes (Predictive → Abc → 123)
- **Long press:** Bring up the TT9 preference screen

#### Star (\*):
- **Short press:** Change case
- **Long press:**
    - When multiple languages are enabled: Change language
    - When single language is enabled: Bring up smiley insert dialog
    - Numeric mode: Insert a star

#### Hash/Pound (#):
- **Short press:** Space
- **Long press:**
    - New line
    - Numeric mode: Insert hash/pound (#)

#### Back (↩):
- **Short Press when there is text:** Usually, "backspace". However, some applications, most notably Firefox and Spotify, forbid this action in their search fields. This is due to the fact Android allows applications to take over control of the physical keypad and redefine what buttons do. Unfortunately, nothing can be done in such cases, "Back" will function as the application authors intended, instead of as backspace.
- **Short Press when there is no text:** System default, no special action (usually, go back)
- **Long Press:** System default, no special action

## Configuration Options
TODO...

### Key Remapping
See [the original manual](https://github.com/Clam-/TraditionalT9/wiki/Key-remapping).