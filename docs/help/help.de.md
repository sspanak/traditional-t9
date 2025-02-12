# Traditional T9
Dieses Handbuch erklärt, wie Sie Traditional T9 in verschiedenen Szenarien konfigurieren und verwenden können. Anweisungen zur Installation und Informationen zu den "Lite"- und "Voll"-Versionen finden Sie im [Installationsleitfaden](https://github.com/sspanak/tt9/blob/master/docs/installation.md) auf GitHub. Außerdem lohnt es sich, die [Hauptseite des Repositories](https://github.com/sspanak/tt9) zu besuchen, die den gesamten Quellcode, einen Entwicklerleitfaden, die Datenschutzerklärung und ergänzende Dokumentationen enthält.

## Ersteinrichtung
Nach der Installation müssen Sie Traditional T9 als Android-Tastatur aktivieren. Klicken Sie dazu auf das Launcher-Symbol. Falls eine Aktion erforderlich ist, sind alle Optionen außer der Ersteinrichtung deaktiviert und es wird ein Label angezeigt: "TT9 ist deaktiviert". Gehen Sie zur Ersteinrichtung und aktivieren Sie es.

_Wenn das Symbol direkt nach der Installation nicht angezeigt wird, starten Sie Ihr Telefon neu. Dies ist eine Energiesparmaßnahme von Android, um die Liste neu installierter Apps nicht sofort zu aktualisieren._

### Verwendung auf einem reinen Touchscreen-Handy
Auf Touchscreen-Geräten wird ebenfalls empfohlen, den System-Rechtschreibprüfer zu deaktivieren. Dieser kann nicht verwendet werden, wenn Sie mit den Nummerntasten tippen, sodass Sie durch das Deaktivieren etwas Akkulaufzeit sparen können.

Ein weiteres Problem ist, dass möglicherweise ein verwirrender Dialog "Wort hinzufügen" angezeigt wird, der Wörter zur Standardtastatur des Systems (meistens Gboard) und nicht zum Wörterbuch von Traditional T9 hinzufügt. Um solche Situationen zu vermeiden, muss der System-Rechtschreibprüfer deaktiviert sein.

Falls Sie diesen Schritt ausführen müssen, wird das Element „System-Rechtschreibprüfer“ im Bildschirm für die Ersteinrichtung aktiv sein. Klicken Sie darauf, um die Systemkomponente zu deaktivieren. Wenn kein solches Element vorhanden ist, müssen Sie nichts weiter tun.

Wenn die Einrichtung abgeschlossen ist, schauen Sie sich den Abschnitt [Bildschirmtastatur](#bildschirmtastatur) für weitere Tipps und Tricks an.

### Aktivierung des Prädiktiven Modus
Der Prädiktive Modus erfordert das Laden eines Sprachwörterbuchs, um Wortvorschläge zu bieten. Sie können die aktivierten Sprachen wechseln und ihre Wörterbücher laden unter Einstellungen → [Sprachen](#sprachoptionen). Falls Sie das Laden eines Wörterbuchs vergessen haben, erledigt Traditional T9 dies automatisch, wenn Sie mit dem Tippen beginnen. Weitere Informationen finden Sie [unten](#sprachoptionen).

#### Hinweise für einfache Geräte
Das Laden des Wörterbuchs kann bei leistungsschwachen Geräten zum Absturz führen. Wenn Sie die TT9 "Lite"-Version verwenden, bricht Android den Vorgang möglicherweise ab. Falls das Laden länger als 30 Sekunden dauert, schließen Sie das Ladegerät an oder sorgen Sie dafür, dass der Bildschirm während des Ladens eingeschaltet bleibt.

Sie können dies vermeiden, indem Sie stattdessen die "Voll"-Version verwenden.

#### Hinweise für Android 13 oder höher
Für neu installierte Apps sind die Benachrichtigungen standardmäßig deaktiviert. Es wird empfohlen, diese zu aktivieren, um benachrichtigt zu werden, wenn Wörterbuchaktualisierungen verfügbar sind. Sobald Sie sich dafür entscheiden, sie zu installieren, zeigt TT9 den Fortschritt an. Es werden maximal einmal pro Monat neue Updates veröffentlicht, sodass Sie sich keine Sorgen über zu viele Benachrichtigungen machen müssen.

Sie können die Benachrichtigungen aktivieren, indem Sie zu Einstellungen → Sprachen gehen und Wörterbuchbenachrichtigungen aktivieren.

_Wenn Sie sich entscheiden, die Benachrichtigungen deaktiviert zu lassen, funktioniert TT9 weiterhin einwandfrei. Sie müssen jedoch die Wörterbücher manuell verwalten._

## Hotkeys

Alle Hotkeys können in den Einstellungen → Tastatur → Hotkeys auswählen konfiguriert oder deaktiviert werden.

### Eingabetasten

#### Vorschläge zurück Taste (Standard: Steuerkreuz Links):
Wählt das vorherige Wort/Buchstabenvorschlag aus.

#### Nächster Vorschlag Taste (Standard: Steuerkreuz Rechts):
Wählt das nächste Wort/Buchstabenvorschlag aus.

#### Vorschläge filtern Taste (Standard: Steuerkreuz Oben):
_Nur im Prädiktiven Modus._

- **Einzelner Druck**: Filtert die Vorschlagsliste und zeigt nur diejenigen an, die mit dem aktuellen Wort beginnen. Es spielt keine Rolle, ob es sich um ein vollständiges Wort handelt. Beispiel: Geben Sie "remin" ein und drücken Sie Filtern. Es werden alle Wörter angezeigt, die mit "remin" beginnen: "remin" selbst, "remind", "reminds", "reminded", "reminding" usw.
- **Doppelter Druck**: Erweitert den Filter auf den gesamten Vorschlag. Beispiel: Geben Sie "remin" ein und drücken Sie zweimal Filtern. Es wird zuerst nach "remin" gefiltert und dann auf "remind" erweitert. Sie können den Filter weiter erweitern, bis Sie zum längsten Wörterbucheintrag gelangen.

Filtern ist auch nützlich, um unbekannte Wörter zu tippen. Angenommen, Sie möchten "Anakin" tippen, was nicht im Wörterbuch vorhanden ist. Beginnen Sie mit "A", drücken Sie dann Filtern, um "B" und "C" auszublenden. Drücken Sie dann die Taste 6. Da der Filter aktiviert ist, werden neben den echten Wörterbuchwörtern alle möglichen Kombinationen für 1+6 angezeigt: "A..." + "m", "n", "o". Wählen Sie "n" und drücken Sie Filtern, um Ihre Auswahl zu bestätigen und "An" zu erstellen. Drücken Sie nun die Taste 2, und es werden "An..." + "a", "b" und "c" angeboten. Wählen Sie "a" und fahren Sie fort, bis Sie "Anakin" erhalten.

Wenn das Filtern aktiviert ist, wird der Basistext fett und kursiv dargestellt.

#### Filter löschen Taste (Standard: Steuerkreuz Unten):
_Nur im Prädiktiven Modus._

Entfernt den Vorschlagsfilter, falls aktiviert.

#### Steuerkreuz Mitte (OK oder ENTER):
- Wenn Vorschläge angezeigt werden, wird der aktuell ausgewählte Vorschlag getippt.
- Andernfalls wird die Standardaktion für die aktuelle Anwendung ausgeführt (z. B. eine Nachricht senden, zu einer URL gehen oder eine neue Zeile eingeben).

_**Hinweis:** Jede Anwendung entscheidet selbst, was passiert, wenn OK gedrückt wird, und TT9 hat darauf keinen Einfluss._

_**Hinweis 2:** Um Nachrichten mit OK in Nachrichtenanwendungen zu senden, müssen Sie deren Einstellung „Mit ENTER senden“ oder eine ähnlich benannte Option aktivieren. Wenn die Anwendung keine solche Einstellung hat, unterstützt sie möglicherweise nicht das Senden von Nachrichten auf diese Weise. Verwenden Sie in diesem Fall die App KeyMapper aus dem [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) oder aus [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). Diese erkennt Chat-Apps und simuliert beim Drücken oder Halten einer Hardwaretaste einen Tastendruck auf die Senden-Taste. Weitere Informationen finden Sie im [Schnellstart-Handbuch](https://docs.keymapper.club/quick-start/)._

#### 0-Taste:
- **Im 123 Modus:**
  - **Drücken:** tippt „0“.
  - **Halten:** tippt Sonder-/Mathematikzeichen.
  - **Halten der „0“ und Drücken der Umschalt-Taste (Standard: Halten der „0“, Drücken von „✱“):** tippt Währungszeichen
- **Im ABC Modus:**
  - **Drücken:** tippt Leerzeichen, neue Zeile oder Sonder-/Mathematikzeichen.
  - **Halten:** tippt „0“.
  - **Drücken „0“ und Drücken der Umschalt-Taste (Standard: Drücken „0“, „✱“):** tippt Währungszeichen
- **Im Prädiktiven Modus:**
  - **Drücken:** tippt Leerzeichen, neue Zeile oder Sonder-/Mathematikzeichen.
  - **Doppeldruck:** tippt das Zeichen, das in den Einstellungen für den Prädiktiven Modus zugewiesen wurde (Standard: „.“)
  - **Halten:** tippt „0“.
  - **Drücken „0“ und Drücken der Umschalt-Taste (Standard: Drücken „0“, „✱“):** tippt Währungszeichen
- **Im Cheonjiin-Modus (Koreanisch):**
  - **Drücken:** Gibt "ㅇ" und "ㅁ" ein.
  - **Halten:** Gibt Leerzeichen, neue Zeilen, "0" oder Sonder-/Mathematikzeichen ein.
  - **Halten von "0" und Drücken von Shift (Standard: Halten von "0", Drücken von "✱"):** Gibt Währungszeichen ein.

#### 1-Taste:
- **Im 123 Modus:**
  - **Drücken:** tippt „1“.
  - **Halten:** tippt Satzzeichen
- **Im ABC Modus:**
  - **Drücken:** tippt Satzzeichen
  - **Halten:** tippt „1“.
- **Im Prädiktiven Modus:**
  - **Drücken:** tippt Satzzeichen
  - **Mehrfaches Drücken:** tippt Emoji
  - **Drücken von 1-1-3:** tippt benutzerdefinierte Emojis (diese müssen zuvor über die [Wort hinzufügen-Taste](#wort-hinzufügen-taste) hinzugefügt worden sein)
  - **Halten:** tippt „1“.
- **Im Cheonjiin-Modus (Koreanisch):**
  - **Drücken:** tippt den Vokal "ㅣ".
  - **Halten:** tippt Satzzeichen.
  - **Halten, dann drücken:** tippt Emoji.
  - **Halten 1, 1 drücken, 3 drücken:** tippt benutzerdefinierte Emojis (diese müssen zuvor über die [Wort hinzufügen-Taste](#wort-hinzufügen-taste) hinzugefügt worden sein)

#### 2- bis 9-Taste:
- **Im 123 Modus:** tippt die entsprechende Zahl
- **Im ABC- und Prädiktiven Modus:** tippt einen Buchstaben oder hält gedrückt, um die entsprechende Zahl zu tippen.

### Funktionstasten

#### Wort hinzufügen Taste:
Fügt ein neues Wort zum Wörterbuch für die aktuelle Sprache hinzu.

Sie können auch neue Emojis hinzufügen und dann durch Drücken von 1-1-3 darauf zugreifen. Unabhängig von der aktuell ausgewählten Sprache sind alle Emojis in allen Sprachen verfügbar.

#### Rückschritt Taste (Zurück, Löschen oder Rückschritt):
Löscht Text.

Wenn Ihr Telefon über eine spezielle „Löschen“- oder „Löschen“-Taste verfügt, müssen Sie in den Einstellungen nichts festlegen, es sei denn, Sie möchten einen zusätzlichen Rückschritt-Taste verwenden. In diesem Fall wird automatisch die leere Option: „--“ vorab ausgewählt.

Auf Telefonen, die eine kombinierte „Löschen“- und „Zurück“-Taste haben, wird diese Taste automatisch ausgewählt. Sie können jedoch die Funktion „Rückschritt“ einer anderen Taste zuweisen, sodass „Zurück“ nur zurück navigiert.

_**NB:** Die Verwendung der "Zurück"-Taste als Rückschritt funktioniert nicht in allen Anwendungen, insbesondere nicht in Firefox, Spotify und Termux. Diese können die Taste vollständig kontrollieren und ihre Funktion neu definieren, was bedeutet, dass sie das tut, was die App-Entwickler vorgesehen haben. Leider kann daran nichts geändert werden, da die „Zurück“-Taste in Android eine besondere Rolle spielt und deren Verwendung systembedingt eingeschränkt ist._

_**NB 2:** Das Halten der „Zurück“-Taste löst immer die Standard-Systemaktion aus (d. h. zeigt die Liste der laufenden Anwendungen an)._

_In diesen Fällen können Sie eine andere Taste zuweisen (alle anderen Tasten sind voll nutzbar) oder die Rückschritt-Taste auf dem Bildschirm verwenden._

#### Nächster Eingabemodus Taste (Standard: drücken #):
Durchläuft die Eingabemodi (abc → Prädiktiv → 123).

_Der Prädiktive Modus ist in Passwortfeldern nicht verfügbar._

_In reinen Zahlenfeldern ist ein Wechsel des Modus nicht möglich. In solchen Fällen kehrt die Taste zu ihrer Standardfunktion zurück (d. h. „#“ tippen)._

#### Text bearbeiten Taste:
Zeigt das Textbearbeitungsfenster, das es Ihnen ermöglicht, Text auszuwählen, zu schneiden, zu kopieren und einzufügen. Sie können das Fenster schließen, indem Sie erneut die „✱“-Taste drücken oder in den meisten Anwendungen die Zurück-Taste drücken. Details sind [unten](#textbearbeitung) verfügbar.

#### Nächste Sprache Taste (Standard: Halten #):
Wählt die nächste Sprache, wenn in den Einstellungen mehrere Sprachen aktiviert wurden.

#### Tastatur auswählen Taste:
Öffnet den Android-Dialog "Tastatur wechseln", in dem Sie zwischen allen installierten Tastaturen auswählen können.

#### Umschalttaste (Standard: Drücken ✱):
- **Beim Tippen von Text:** Umschalten zwischen Groß- und Kleinschreibung.
- **Beim Tippen von Sonderzeichen mit der 0-Taste**: Zeigt die nächste Zeichenkategorie an.

#### Einstellungen anzeigen Taste:
Öffnet den Einstellungsbildschirm. Hier können Sie die Sprachen für das Tippen auswählen, die Hotkeys der Tastatur konfigurieren, das Erscheinungsbild der Anwendung ändern oder die Kompatibilität mit Ihrem Telefon verbessern.

#### Spracheingabe Taste:
Aktiviert die Spracheingabe auf kompatiblen Telefonen. Weitere Informationen finden Sie [unten](#spracheingabe).

#### Befehlsliste Taste / aka Befehlsübersicht / (Standard: Halten ✱):
Zeigt eine Liste aller Befehle (oder Funktionen) an.

Viele Telefone verfügen nur über zwei oder drei "freie" Tasten, die als Hotkeys verwendet werden können. Traditional T9 hat jedoch viele weitere Funktionen, sodass auf der Tastatur einfach kein Platz für alle vorhanden ist. Die Befehlsübersicht löst dieses Problem. Es ermöglicht das Ausführen zusätzlicher Funktionen (oder Befehle) durch Tastenkombinationen.

Im Folgenden finden Sie eine Liste der möglichen Befehle:
- **Einstellungsbildschirm anzeigen (Standardkombination: Halten ✱, Taste 1).** Entspricht dem Drücken der Taste [Einstellungen anzeigen](#einstellungen-anzeigen-taste).
- **Wort hinzufügen (Standardkombination: Halten ✱, Taste 2).** Entspricht dem Drücken der Taste [Wort hinzufügen](#wort-hinzufügen-taste).
- **Spracheingabe (Standardkombination: Halten ✱, Taste 3).** Entspricht dem Drücken der Taste [Spracheingabe](#spracheingabe-taste).
- **Text bearbeiten (Standardkombination: Halten ✱, Taste 5).** Entspricht dem Drücken der Taste [Text bearbeiten](#text-bearbeiten-taste).
- **Andere Tastatur auswählen (Standardkombination: Halten ✱, Taste 8).** Entspricht dem Drücken der Taste [Tastatur auswählen](#tastatur-auswählen-taste).

_Diese Taste hat keine Funktion, wenn das Bildschirm-Layout auf „Virtuelle Tastatur“ eingestellt ist, da alle Tasten für alle möglichen Funktionen bereits auf dem Bildschirm verfügbar sind._

## Spracheingabe
Die Spracheingabefunktion ermöglicht eine Sprache-zu-Text-Eingabe, ähnlich wie bei Gboard. Wie bei allen anderen Tastaturen führt Traditional T9 selbst keine Spracherkennung durch, sondern fordert Ihr Telefon dazu auf.

_Die Taste für Spracheingabe ist auf Geräten, die diese Funktion nicht unterstützen, ausgeblendet._

### Unterstützte Geräte
Auf Geräten mit Google-Diensten wird die Google Cloud-Infrastruktur genutzt, um Ihre Sprache in Text umzuwandeln. Dafür ist eine Verbindung zu einem WLAN oder die Aktivierung mobiler Daten erforderlich.

Auf Geräten ohne Google, aber mit einer Sprachassistenten-App oder einer nativen Tastatur, die Spracheingabe unterstützt, wird für die Spracherkennung die jeweils verfügbare Option verwendet. Beachten Sie, dass diese Methode wesentlich eingeschränkter ist als die von Google. Sie funktioniert nicht in lauten Umgebungen und erkennt meist nur einfache Befehle wie: "Kalender öffnen" oder "Musik abspielen". Der Vorteil ist, dass sie offline funktioniert.

Andere Telefone ohne Google unterstützen Spracheingabe in der Regel nicht. Chinesische Telefone verfügen aufgrund chinesischer Sicherheitsrichtlinien über keine Spracherkennungsfunktionen. Auf diesen Geräten kann es möglich sein, die Spracheingabe zu aktivieren, indem die Google-Anwendung installiert wird (Paketname: "com.google.android.googlequicksearchbox").

## Bildschirmtastatur
Auf reinen Touchscreen-Telefonen ist eine voll funktionsfähige Bildschirmtastatur verfügbar, die automatisch aktiviert wird. Falls Ihr Telefon aus irgendeinem Grund nicht als Touchscreen-Gerät erkannt wurde, aktivieren Sie die Funktion unter Einstellungen → Erscheinungsbild → Bildschirm-Layout und wählen Sie „Virtuelles Tastenfeld“.

Falls Sie sowohl einen Touchscreen als auch eine Hardwaretastatur haben und mehr Bildschirmfläche wünschen, können Sie die Softwaretasten unter Einstellungen → Erscheinungsbild deaktivieren.

Es wird auch empfohlen, das spezielle Verhalten der "Zurück"-Taste als "Rückschritt" zu deaktivieren. Dies ist nur für eine Hardwaretastatur sinnvoll. In der Regel geschieht dies auch automatisch, aber falls nicht, gehen Sie zu Einstellungen → Tastatur → Hotkeys auswählen → Rückschritt-Taste und wählen die Option "--" aus.

### Übersicht der virtuellen Tasten
Die Bildschirmtastatur funktioniert genauso wie das Nummernfeld eines Telefons mit physischen Tasten. Wenn eine Taste nur eine Funktion bietet, hat sie ein Label (oder Symbol), das diese Funktion anzeigt. Wenn die Taste eine sekundäre "Halten"-Funktion bietet, hat sie zwei Labels (oder Symbole).

Unten finden Sie eine Beschreibung der Tasten mit mehr als einer Funktion.

#### Rechte F2-Taste (zweite Taste von oben in der rechten Spalte)
_Nur im Vorhersagemodus._

- **Drücken:** Die Vorschlagsliste filtern. Siehe [oben](#vorschläge-filtern-taste-standard-steuerkreuz-oben), wie das Wortfiltern funktioniert.
- **Halten:** Löscht den Filter, falls aktiv.

#### Rechte F3-Taste (dritte Taste von oben in der rechten Spalte)
- **Drücken:** Öffnet die Optionen für Kopieren, Einfügen und Textbearbeitung.
- **Halten:** Aktiviert die Spracheingabe.

#### Linke F4-Taste (die untere linke Taste)
- **Drücken:** Wechselt die Eingabemodi (abc → Vorhersage → 123).
- **Halten:** Wechselt die Sprache, wenn mehrere Sprachen in den Einstellungen aktiviert wurden.
- **Horizontal wischen:** Wechselt zur zuletzt verwendeten Tastatur, abgesehen von TT9.
- **Vertikal wischen:** Öffnet den Android-Tastaturwechsel-Dialog, in dem Sie zwischen allen installierten Tastaturen wählen können.

_Die Taste zeigt ein kleines Globus-Symbol an, wenn Sie mehr als eine Sprache unter Einstellungen → Sprachen aktiviert haben. Das Symbol zeigt an, dass es möglich ist, die Sprache durch Halten der Taste zu ändern._

### Tastaturfeld beim Tippen anpassen
In manchen Fällen nimmt das virtuelle Tastenfeld möglicherweise zu viel Platz ein, wodurch Sie Ihren Text oder Anwendungsinhalte nicht sehen können. Sie können die Größe anpassen, indem Sie die Einstellungen-/Befehlspalette-Taste gedrückt halten und ziehen oder die Statusleiste ziehen (dort wird die aktuelle Sprache oder der Eingabemodus angezeigt). Wenn die Höhe zu klein wird, wechselt das Layout automatisch zu „Funktionstasten“ oder „nur Vorschlagsliste“. Beim Vergrößern wechselt das Layout wieder zum „Virtuellen Tastenfeld“. Durch Doppeltippen auf die Statusleiste können Sie das Tastenfeld sofort minimieren oder maximieren.

_Das Anpassen der Größe von Traditional T9 führt auch zur Anpassung der aktuellen Anwendung. Beide Aktionen zusammen sind rechnerisch sehr aufwendig und können auf vielen Telefonen zu Flackern oder Ruckeln führen, selbst auf leistungsfähigeren Geräten._

### Höhe der Tasten ändern
Sie können auch die Höhe der Bildschirmtasten ändern. Gehen Sie dazu zu Einstellungen → Erscheinungsbild → Bildschirmtastenhöhe und passen Sie die Größe nach Bedarf an.

Die Standardeinstellung von 100 % ist ein guter Kompromiss zwischen Bedienbarkeit und genutztem Bildschirmplatz. Falls Sie große Finger haben, können Sie die Einstellung erhöhen. Bei größeren Bildschirmen, wie etwa auf einem Tablet, können Sie die Höhe reduzieren.

_Wenn der verfügbare Bildschirmplatz begrenzt ist, ignoriert TT9 diese Einstellung und reduziert automatisch seine Höhe, um der aktuellen Anwendung genug Platz zu lassen._

## Textbearbeitung
Im Textbearbeitungsfenster können Sie Text wie auf einer Computertastatur auswählen, ausschneiden, kopieren und einfügen. Um die Textbearbeitung zu beenden, drücken Sie die „✱“-Taste oder die Zurück-Taste (außer in Webbrowsern, Spotify und einigen anderen Apps) oder die Buchstabentaste auf der Bildschirmtastatur.

Nachfolgend eine Liste der möglichen Textbefehle:
1. Vorheriges Zeichen auswählen (wie Umschalt + Links auf einer Computertastatur)
2. Auswahl aufheben
3. Nächstes Zeichen auswählen (wie Umschalt + Rechts)
4. Vorheriges Wort auswählen (wie Strg + Umschalt + Links)
5. Alles auswählen
6. Nächstes Wort auswählen (wie Strg + Umschalt + Rechts)
7. Ausschneiden
8. Kopieren
9. Einfügen

Für eine einfachere Bearbeitung sind auch Rückschritt-, Leer- und OK-Tasten aktiv.

## Einstellungsbildschirm
Im Einstellungsbildschirm können Sie Sprachen für die Eingabe wählen, die Hotkeys der Tastatur konfigurieren, das Erscheinungsbild der Anwendung ändern oder die Kompatibilität mit Ihrem Telefon verbessern.

### Wie greife ich auf die Einstellungen zu?

#### Methode 1
Tippen Sie auf das Traditional T9-Symbol.

#### Methode 2 (mit Touchscreen)
- Tippen Sie auf ein Text- oder Zahlenfeld, um TT9 zu aktivieren.
- Verwenden Sie die Zahnrad-Taste auf dem Bildschirm.

#### Methode 3 (mit physischer Tastatur)
- Beginnen Sie in einem Text- oder Zahlenfeld zu tippen, um TT9 zu aktivieren.
- Öffnen Sie die Befehlsliste über die Bildschirmtools-Taste oder durch Drücken der zugewiesenen Hotkey-Taste [Standard: Halten ✱].
- Drücken Sie die 2-Taste.

### Navigation in den Einstellungen
Wenn Sie ein Gerät mit Hardwaretastatur haben, gibt es zwei Möglichkeiten zur Navigation in den Einstellungen.

1. Verwenden Sie die Hoch-/Runter-Tasten zum Scrollen und OK zum Öffnen oder Aktivieren einer Option.
2. Drücken Sie die Tasten 1–9, um die jeweilige Option auszuwählen, und doppeltippen Sie darauf, um sie zu öffnen/aktivieren. Doppeltippen funktioniert überall auf dem Bildschirm. Beispielsweise wird durch Doppeltippen der 3-Taste die dritte Option aktiviert. Die 0-Taste ist eine praktische Abkürzung zum Scrollen ans Ende, öffnet jedoch nicht die letzte Option.

### Sprachoptionen

#### Wörterbuch laden
Nach der Aktivierung einer oder mehrerer neuer Sprachen müssen die jeweiligen Wörterbücher für den prädiktiven Modus geladen werden. Einmal geladene Wörterbücher bleiben gespeichert, bis Sie eine der „Löschen“-Optionen verwenden. Dies bedeutet, dass Sie Sprachen aktivieren und deaktivieren können, ohne deren Wörterbücher jedes Mal neu laden zu müssen. Nur beim ersten Mal ist dies erforderlich.

Wenn Sie Sprache X verwenden möchten, können Sie sicher alle anderen Sprachen deaktivieren, nur das Wörterbuch X laden (Zeit sparen!) und anschließend die zuvor genutzten Sprachen wieder aktivieren.

Das Neuladen eines Wörterbuchs setzt die Beliebtheit von Vorschlägen auf die Werkseinstellungen zurück. Dies sollte jedoch keine Bedenken auslösen. In den meisten Fällen werden Sie kaum Änderungen in der Reihenfolge der Vorschläge bemerken, es sei denn, Sie verwenden häufig ungewöhnliche Wörter.

#### Automatisches Laden von Wörterbüchern

Falls Sie das Laden eines Wörterbuchs im Einstellungsbildschirm überspringen oder vergessen, wird dies automatisch geschehen, wenn Sie in einer Anwendung den prädiktiven Modus aktivieren. Sie werden gebeten, zu warten, bis das Laden abgeschlossen ist, und können dann direkt mit dem Tippen beginnen.

Gelöschte Wörterbücher werden NICHT automatisch neu geladen. Sie müssen dies manuell durchführen. Nur Wörterbücher für neu aktivierte Sprachen werden automatisch geladen.

#### Wörterbuch löschen
Falls Sie Sprachen X oder Y nicht mehr verwenden, können Sie diese deaktivieren und auch „Nicht ausgewählte löschen“ verwenden, um Speicherplatz freizugeben.

Um alles zu löschen, unabhängig von der Auswahl, verwenden Sie „Alles löschen“.

In allen Fällen bleiben Ihre selbst hinzugefügten Wörter erhalten und werden wiederhergestellt, sobald Sie das jeweilige Wörterbuch neu laden.

#### Hinzugefügte Wörter
Die Option „Exportieren“ ermöglicht es, alle hinzugefügten Wörter für alle Sprachen, einschließlich hinzugefügter Emojis, in eine CSV-Datei zu exportieren. Diese CSV-Datei kann dann verwendet werden, um Traditional T9 zu verbessern! Gehen Sie zu GitHub und teilen Sie die Wörter in einem [neuen Issue](https://github.com/sspanak/tt9/issues) oder [Pull-Request](https://github.com/sspanak/tt9/pulls). Nach einer Überprüfung werden sie in der nächsten Version aufgenommen.

Mit „Importieren“ können Sie eine zuvor exportierte CSV-Datei importieren. Es gibt jedoch einige Einschränkungen:
- Es können nur Wörter aus Buchstaben importiert werden. Apostrophe, Bindestriche, andere Satzzeichen oder Sonderzeichen sind nicht erlaubt.
- Emojis sind nicht erlaubt.
- Eine CSV-Datei kann maximal 250 Wörter enthalten.
- Sie können bis zu 1000 Wörter importieren, also maximal 4 Dateien x 250 Wörter. Über dieses Limit hinaus können Sie beim Tippen weiterhin Wörter hinzufügen.

Mit „Löschen“ können Sie nach falsch geschriebenen Wörtern suchen und diese oder andere unerwünschte Wörter aus dem Wörterbuch entfernen.

### Kompatibilitätsoptionen
Für verschiedene Anwendungen oder Geräte ist es möglich, spezielle Optionen zu aktivieren, die Traditional T9 besser kompatibel machen. Diese finden Sie am Ende jeder Einstellungsseite unter dem Abschnitt Kompatibilität.

#### Alternative Methode zum Scrollen durch Vorschläge
_In: Einstellungen → Erscheinungsbild._

Auf einigen Geräten kann es im prädiktiven Modus vorkommen, dass die Liste nicht bis zum Ende gescrollt werden kann oder mehrmals vor- und zurückgescrollt werden muss, bis der letzte Vorschlag erscheint. Dieses Problem tritt manchmal bei Android 9 oder älter auf. Aktivieren Sie die Option, falls Sie dieses Problem haben.

#### Immer im Vordergrund
_Unter: Einstellungen → Erscheinungsbild._

Auf einigen Telefonen, insbesondere dem Sonim XP3plus (XP3900), wird Traditional T9 möglicherweise nicht angezeigt, wenn Sie zu tippen beginnen, oder es wird teilweise von den Softkeys verdeckt. In anderen Fällen können weiße Balken darum erscheinen. Das Problem kann in einer bestimmten Anwendung oder in allen auftreten. Um dies zu verhindern, aktivieren Sie die Option „Immer im Vordergrund“.

#### Schutz vor Tastenwiederholung
_Unter: Einstellungen → Tastenfeld._

Die Telefone CAT S22 Flip und Qin F21 sind für ihre minderwertigen Tastenfelder bekannt, die im Laufe der Zeit schnell abnutzen und bei einem Tastendruck mehrere Klicks registrieren. Dies kann beim Tippen oder Navigieren in den Telefonmenüs auffallen.

Für CAT-Telefone wird eine Einstellung von 50–75 ms empfohlen. Für das Qin F21 versuchen Sie es mit 20–30 ms. Wenn das Problem weiterhin besteht, erhöhen Sie den Wert etwas, aber versuchen Sie, ihn so niedrig wie möglich zu halten.

_**Hinweis:** Je höher der Wert, desto langsamer müssen Sie tippen. TT9 ignoriert sehr schnelle Tastendrücke._

_**Hinweis 2:** Neben dem oben genannten können Qin-Telefone möglicherweise auch lange Tastendrücke nicht erkennen. In diesem Fall lässt sich leider nichts tun._

#### Telegram/Snapchat Sticker und Emoji-Panels lassen sich nicht öffnen
Dies passiert, wenn Sie eines der kleineren Layouts verwenden. Es gibt derzeit keine dauerhafte Lösung, aber Sie können den folgenden Workaround nutzen:
- Gehen Sie zu Einstellungen → Erscheinungsbild und aktivieren Sie „Bildschirm-Ziffernblock“.
- Gehen Sie zurück zum Chat und klicken Sie auf die Emoji- oder die Sticker-Taste. Sie werden jetzt angezeigt.
- Sie können nun in die Einstellungen zurückkehren und den Bildschirm-Ziffernblock wieder deaktivieren. Die Emoji- und Sticker-Panels bleiben zugänglich, bis Sie die App oder das Telefon neu starten.

#### Traditional T9 erscheint nicht sofort in einigen Anwendungen
Wenn Sie eine Anwendung geöffnet haben, in der Sie tippen können, und TT9 nicht automatisch erscheint, beginnen Sie einfach mit dem Tippen, und es wird angezeigt. Alternativ können Sie auch die Hotkeys drücken, um den [Eingabemodus](#nächster-vorschlag-taste-standard-steuerkreuz-rechts) oder die [Sprache](#nächste-sprache-taste-standard-halten) zu wechseln. Dadurch wird TT9 angezeigt, wenn es verborgen ist.

Auf einigen Geräten bleibt TT9 möglicherweise unsichtbar, egal was Sie tun. In solchen Fällen müssen Sie [Immer im Vordergrund](#immer-im-vordergrund) aktivieren.

**Lange Erklärung.** Der Grund für dieses Problem ist, dass Android primär für Touchscreen-Geräte konzipiert ist und erwartet, dass Sie das Text-/Zahlenfeld berühren, um die Tastatur anzuzeigen. Es ist möglich, TT9 ohne diese Bestätigung anzeigen zu lassen, aber dann vergisst Android manchmal, sie zu verbergen, wenn es nötig ist, z.B. nach der Eingabe einer Telefonnummer oder dem Abschicken von Text in einem Suchfeld.

Um sich an den Android-Standard zu halten, liegt die Kontrolle in Ihren Händen. Drücken Sie einfach eine Taste, um den Bildschirm zu „berühren“ und tippen Sie weiter.

#### Auf dem Qin F21 Pro erhöht oder verringert das Halten der 2- oder 8-Taste die Lautstärke anstatt eine Zahl zu tippen
Um dieses Problem zu lindern, gehen Sie zu Einstellungen → Erscheinungsbild und aktivieren Sie das „Statussymbol“. TT9 sollte das Qin F21 automatisch erkennen und die Einstellungen aktivieren. Falls die automatische Erkennung fehlschlägt oder Sie das Symbol aus irgendeinem Grund deaktiviert haben, müssen Sie es aktivieren, damit alle Tasten ordnungsgemäß funktionieren.

**Lange Erklärung.** Das Qin F21 Pro (möglicherweise auch F22) hat eine Hotkey-Anwendung, die das Zuweisen der Lautstärkeregelung an Zahlentasten ermöglicht. Standardmäßig ist der Hotkey-Manager aktiviert, und das Halten der 2-Taste erhöht die Lautstärke, das Halten der 8-Taste verringert sie. Wenn jedoch kein Statussymbol vorhanden ist, geht der Manager davon aus, dass keine Tastatur aktiv ist und regelt die Lautstärke, anstatt die Taste für Traditional T9 zu verwenden, um eine Zahl zu tippen. Durch Aktivieren des Symbols wird der Hotkey-Manager umgangen und alles funktioniert ordnungsgemäß.

#### Allgemeine Probleme auf Xiaomi-Telefonen
Xiaomi hat mehrere nicht-standardmäßige Berechtigungen eingeführt, die das ordnungsgemäße Funktionieren von Traditional T9s virtueller Bildschirmtastatur verhindern können. Genauer gesagt funktionieren die Tasten „Einstellungen anzeigen“ und „Wort hinzufügen“ möglicherweise nicht wie vorgesehen. Um dies zu beheben, müssen Sie die Berechtigungen „Pop-up-Fenster anzeigen“ und „Pop-up-Fenster im Hintergrund anzeigen“ für TT9 in den Einstellungen Ihres Telefons erteilen. [Dieser Leitfaden](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) für eine andere Anwendung erklärt, wie Sie dies tun.

Es wird auch dringend empfohlen, die Berechtigung „Dauerhafte Benachrichtigung“ zu erteilen. Dies ähnelt der Benachrichtigungsberechtigung, die in Android 13 eingeführt wurde. Weitere Informationen finden Sie [oben](#hinweise-für-android-13-oder-höher).

_Die Xiaomi-Probleme wurden in [diesem GitHub-Problem](https://github.com/sspanak/tt9/issues/490) besprochen._

#### Spracheingabe dauert sehr lange, um zu stoppen
Es ist [ein bekanntes Problem](https://issuetracker.google.com/issues/158198432) unter Android 10, das Google nie behoben hat. Es ist auf der TT9-Seite nicht möglich, das zu lindern. Um den Sprachbefehl zu beenden, bleiben Sie ein paar Sekunden lang ruhig. Android schaltet das Mikrofon automatisch aus, wenn keine Sprache erkannt wird.

## Häufig gestellte Fragen

#### Kannst du nicht Funktion X hinzufügen?
Nein.

Jeder hat seine eigenen Vorlieben. Manche möchten größere Tasten, manche eine andere Anordnung, manche eine Schnellzugriffstaste für ".com", und manche vermissen ihr altes Telefon oder ihre alte Tastatur. Aber bitte versteht, dass ich dies in meiner Freizeit freiwillig mache. Es ist unmöglich, Tausende von unterschiedlichen Wünschen zu erfüllen, von denen einige sich sogar widersprechen.

Henry Ford sagte einmal: „Es kann jede Farbe haben, die der Kunde will, solange sie schwarz ist.“ Ebenso ist Traditional T9 schlicht, effektiv und kostenlos – aber du bekommst, was du bekommst.

#### Kannst du es nicht mehr wie Sony Ericsson oder Xperia, Nokia C2, Samsung oder eine andere Software-Tastatur machen?
Nein.

Traditional T9 ist nicht als Ersatz oder Klon-App gedacht. Es hat sein eigenes einzigartiges Design, das hauptsächlich von den Nokia 3310 und 6303i inspiriert wurde. Während es das Gefühl der Klassiker einfängt, bietet es eine eigene Erfahrung, die kein Gerät exakt nachahmen wird.

#### Du solltest Touchpal kopieren, es ist die beste Tastatur der Welt!
Nein, sollte ich nicht. Siehe die vorherigen Punkte.

Touchpal war 2015 vielleicht die beste Tastatur, als es noch keine echte Konkurrenz gab. Aber seitdem hat sich viel verändert. Sieh dir den Vergleich zwischen Traditional T9 und Touchpal an:

_**Traditional T9**_
- Respektiert deine Privatsphäre.
- Enthält keine Werbung und ist kostenlos.
- Unterstützt eine breite Palette von Geräten: Tastenhandys und Fernseher mit Hardware-Tastaturen sowie reine Touchscreen-Smartphones und Tablets.
- Bietet ein echtes 12-Tasten-T9-Layout für jede Sprache.
- Verbessert Wortvorschläge. Zum Beispiel, wenn du textonyme Ausdrücke wie „go in“ tippst, wird es lernen, nicht „go go“ oder „in in“ vorzuschlagen, sondern den beabsichtigten Ausdruck.
- Alles, was du tippst, bleibt auf deinem Gerät. Es werden keine Informationen gesendet.
- Ist Open Source, sodass du den Quellcode und die Wörterbücher einsehen oder zum Projekt beitragen kannst.
- Hat ein klares und gut lesbares Design, das sich in das System einfügt. Es gibt keine unnötigen Spielereien, sodass du dich aufs Tippen konzentrieren kannst.
- Die Ladegeschwindigkeit des Wörterbuchs ist langsam.

_**Touchpal**_
- Fordert aggressiv Zugriff auf dein gesamtes Gerät und deine Kontakte, schreibt zufällige Dateien überall; wurde schließlich aus dem Play Store verbannt, weil es sich wie ein Virus verhielt.
- Enthält viele Anzeigen.
- Unterstützt nur Touchscreen-Geräte.
- Ist keine echte T9-Tastatur. Es bietet ein T9-Layout nur in einigen Sprachen an. Zudem sind einige Layouts fehlerhaft (z. B. fehlt im bulgarischen Layout ein Buchstabe, und einige Buchstaben sind zwischen der 8er- und 9er-Taste vertauscht).
- Beim Eingeben von Textonymen schlägt es nur das zuletzt gewählte Wort vor. Zum Beispiel wird bei „go in“ entweder „go go“ oder „in in“ angezeigt.
- Cloud-basierte Vorschläge könnten die Genauigkeit verbessern. Damit das funktioniert, müssen jedoch du und alle anderen Nutzer alles, was ihr tippt, an die Touchpal-Server senden.
- Geschlossene Quelle. Es gibt keine Möglichkeit zu überprüfen, was im Hintergrund passiert.
- Enthält viele Themes, Farben, GIFs und andere Ablenkungen, die nichts mit dem Tippen zu tun haben.
- Die Ladegeschwindigkeit des Wörterbuchs ist schnell. Touchpal gewinnt diesen Punkt.

Wenn du anderer Meinung bist oder deine Sichtweise erklären möchtest, beteilige dich an [der offenen Diskussion](https://github.com/sspanak/tt9/issues/647) auf GitHub. Bitte sei respektvoll gegenüber anderen. Hasskommentare werden nicht toleriert.

#### Ich muss ein QWERTY-Layout verwenden (nur Touchscreen-Geräte)
Traditional T9 ist eine T9-Tastatur und bietet daher kein QWERTY-Layout.

Falls Sie noch lernen, T9 zu verwenden, und gelegentlich zurückwechseln müssen, oder es Ihnen praktischer erscheint, neue Wörter über QWERTY einzugeben, wischen Sie die linke F4-Taste nach oben, um zu einer anderen Tastatur zu wechseln. Weitere Informationen finden Sie in der [Übersicht über die virtuellen Tasten](#übersicht-der-virtuellen-tasten). Denken Sie daran, den anderen gegenüber respektvoll zu sein. Hassbeiträge werden nicht toleriert.

Die meisten anderen Tastaturen erlauben das Zurückwechseln zu Traditional T9, indem Sie die Leertaste oder die „Sprache wechseln“-Taste gedrückt halten. Sehen Sie im jeweiligen Handbuch nach.

#### Ich kann die Sprache auf einem Touchscreen-Telefon nicht ändern
Stellen Sie zuerst sicher, dass Sie alle gewünschten Sprachen unter Einstellungen → Sprachen aktiviert haben. Halten Sie dann die [linke F4-Taste](#linke-f4-taste-die-untere-linke-taste), um die Sprache zu ändern.