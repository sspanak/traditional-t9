# Traditional T9
Bu kılavuz, Traditional T9'un farklı senaryolarda nasıl yapılandırılacağını ve kullanılacağını açıklar. Kurulum talimatları ve "lite" ve "full" sürümleri hakkında bilgi için lütfen GitHub'daki [Kurulum Kılavuzu'na](https://github.com/sspanak/tt9/blob/master/docs/installation.md) bakın. Son olarak, tüm kaynak kodları, bir geliştirici kılavuzunu, gizlilik politikasını ve ek belgeleri içeren [ana depo sayfasına](https://github.com/sspanak/tt9) göz atabilirsiniz.

## İlk Kurulum
Kurulumu yaptıktan sonra, ilk olarak Traditional T9'u bir Android klavyesi olarak etkinleştirmeniz gerekir. Bunu yapmak için başlatıcı simgesine tıklayın. Herhangi bir işlem yapmanız gerekiyorsa, İlk Kurulum dışındaki tüm seçenekler devre dışı bırakılacak ve bir etiket görünecektir: "TT9 devre dışı". İlk Kuruluma gidin ve etkinleştirin.

_Yüklemeden hemen sonra simgeyi görmüyorsanız, telefonunuzu yeniden başlatın, simge görünmelidir. Bu, Android'in yeni yüklenen uygulamalar listesini yenilemeyerek biraz pil tasarrufu sağlamaya çalışmasından kaynaklanmaktadır._

### Sadece Dokunmatik Ekranlı Telefonlarda Kullanım
Dokunmatik ekran cihazlarında, sistemin yazım denetleyicisini devre dışı bırakmak da önemle tavsiye edilir. Yazarken numara tuşları kullanıldığında işlev göremez, bu nedenle devre dışı bırakarak pil tasarrufu yapabilirsiniz.

Bir başka sorun da, karışıklığa neden olabilecek "Kelime Ekle" açılır iletişim kutusunu göstermesidir. Bu iletişim kutusu varsayılan sistem klavyesine (genellikle Gboard) ve değil, Traditional T9'un sözlüğüne kelimeler ekler. Bu tür durumları önlemek için sistem yazım denetleyicisi devre dışı bırakılmalıdır.

Bu adımı yapmanız gerekiyorsa, İlk Kurulum ekranında "Sistem Yazım Denetleyicisi" öğesi etkin olacaktır. Sistem bileşenini devre dışı bırakmak için üzerine tıklayın. Böyle bir öğe yoksa başka bir şey yapmanıza gerek yoktur.

Kurulumu tamamladıktan sonra daha fazla ipucu ve püf noktası için [Ekran Üzerindeki Tuş Takımı bölümüne](#ekran-üzeri-tuș-takımı) göz atın.

### Tahmin Modunu Etkinleştirme
Tahmin Modu, kelime önerileri sağlamak için bir dil sözlüğünün yüklenmesini gerektirir. Etkin dilleri değiştirebilir ve Ayarlar Ekranı → [Diller](#dil-seçenekleri) bölümünden sözlüklerini yükleyebilirsiniz. Sözlüklerden bazılarını yüklemeyi unutursanız, Traditional T9 yazmaya başladığınızda otomatik olarak yükleyecektir. Daha fazla bilgi için [aşağıya bakın](#dil-seçenekleri).

#### Düşük Donanımlı Telefonlar için Notlar
Sözlük yükleme, düşük donanımlı telefonları zorlayabilir. TT9 "lite" sürümü kullanılırken, bu durum Android'in işlemi sonlandırmasına neden olabilir. Yükleme 30 saniyeden fazla sürerse, şarj cihazını takın veya yükleme sırasında ekranın açık kalmasını sağlayın.

Yukarıdaki sorunu önlemek için "full" sürümünü kullanabilirsiniz.

#### Android 13 veya Üstü için Notlar
Varsayılan olarak, yeni yüklenen uygulamaların bildirimleri devre dışıdır. Bu bildirimleri etkinleştirmeniz önerilir. Bu sayede sözlük güncellemeleri olduğunda bilgilendirilirsiniz ve yüklemeyi seçtiğinizde TT9 yükleme ilerlemesini gösterir. Yeni güncellemeler en fazla ayda bir kez yayınlanır, bu yüzden aşırı bildirim almaktan endişelenmenize gerek yok.

Bildirimleri etkinleştirmek için Ayarlar → Diller'e gidin ve Sözlük Bildirimlerini açın.

_Bildirimleri kapalı tutmaya karar verirseniz, TT9 çalışmaya devam edecektir, ancak sözlükleri manuel olarak yönetmeniz gerekecektir._

## Kısayol Tuşları

Tüm kısayol tuşları, Ayarlar → Tuş Takımı → Kısayol Tuşlarını Seç bölümünden yeniden yapılandırılabilir veya devre dışı bırakılabilir.

### Yazı Tuşları

#### Önceki Öneri Tuşu (Varsayılan: D-pad Sol):
Önceki kelime/harf önerisini seçin.

#### Sonraki Öneri Tuşu (Varsayılan: D-pad Sağ):
Sonraki kelime/harf önerisini seçin.

#### Öneri Filtreleme Tuşu (Varsayılan: D-pad Yukarı):
_Tahmin modu yalnızca._

- **Tek basış:** Öneri listesini filtreleyin, yalnızca geçerli kelimeyle başlayanları bırakın. Bu tam bir kelime olup olmaması fark etmez. Örneğin, "remin" yazın ve Filtreye basın. "remin" ile başlayan tüm kelimeler kalacaktır: "remin", "remind", "reminds", "reminded", "reminding" vb.
- **Çift basış:** Filtreyi tam öneriye genişletin. Örneğin, "remin" yazın ve Filtreye iki kez basın. Önce "remin"e göre filtreleyecek, ardından filtreyi "remind"a genişletecek. En uzun sözlük kelimesine ulaşana kadar filtreyi genişletmeye devam edebilirsiniz.

Filtreleme, bilinmeyen kelimeleri yazmak için de faydalıdır. Örneğin, sözlükte olmayan "Anakin" kelimesini yazmak istediğinizi varsayalım. "A" ile başlayın, ardından "B" ve "C"yi gizlemek için Filtre'ye basın. Şimdi 6-tușuna basın. Filtre açık olduğundan, gerçek sözlük kelimelerinin yanı sıra 1+6 için tüm olası kombinasyonları sunacaktır: "A..." + "m", "n", "o". "n"i seçin ve seçimizi onaylamak için Filtreye basın, "An" üretilir. Şimdi 2-tușuna basarak "An..." + "a", "b", ve "c" elde edebilirsiniz. "a" seçin ve "Anakin" elde edene kadar devam edin.

Filtreleme etkinleştirildiğinde, temel metin kalın ve italik hale gelir.

#### Filtreyi Temizleme Tușu (Varsayılan: D-pad Așağı):
_Tahmin modu yalnızca._

Uygulanan öneri filtresini temizleyin.

#### D-pad Merkezi (OK veya ENTER):
- Öneriler görüntüleniyorsa, şu anki seçili öneriyi yazın.
- Aksi halde, mevcut uygulama için varsayılan işlemi gerçekleştirin (örneğin, bir mesaj gönderin, bir URL'ye gidin veya yeni satıra geçin).

_**Not:** Her uygulama, OK tuşuna basıldığında ne yapılacağını kendisi belirler ve TT9'un üzerinde kontrolü yoktur._

_**Not 2:** Mesajlaşma uygulamalarında OK ile mesaj göndermek için, uygulamanın "ENTER ile Gönder" veya benzer isimli ayarını etkinleştirmeniz gerekir. Uygulamada böyle bir ayar yoksa, muhtemelen bu şekilde mesaj göndermeyi desteklemiyordur. Bu durumda, [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) veya [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/) üzerinden KeyMapper uygulamasını kullanın. KeyMapper, sohbet uygulamalarını algılayabilir ve bir donanım tuşuna basıldığında veya basılı tutulduğunda mesaj gönderme butonuna dokunmayı simüle edebilir. Daha fazla bilgi için [hızlı başlangıç kılavuzuna](https://docs.keymapper.club/quick-start/) göz atın._

#### 0-tușu:
- **123 modunda:**
  - **Bas:** "0" yaz.
  - **Basılı tut:** özel/matematik karakterleri yaz.
  - **"0" basılı tut, ardından Shift'e bas (Varsayılan: "0"u basılı tut, "✱"e bas):** para birimi karakterleri yaz.
- **ABC modunda:**
  - **Bas:** boşluk, yeni satır veya özel/matematik karakterleri yaz.
  - **Basılı tut:** "0" yaz.
  - **"0" bas, ardından Shift'e bas (Varsayılan: "0" bas, "✱"e bas):** para birimi karakterleri yaz.
- **Tahmin modunda:**
  - **Bas:** boşluk, yeni satır veya özel/matematik karakterleri yaz.
  - **Çift bas:** Tahmin modunda ayarlanan karakteri yaz. (Varsayılan: ".")
  - **Basılı tut:** "0" yaz.
  - **"0" bas, ardından Shift'e bas (Varsayılan: "0" bas, "✱"e bas):** para birimi karakterleri yaz.
- **Cheonjiin modunda (Korece):**
  - **Bas:** "ㅇ" ve "ㅁ" yaz.
  - **Basılı tut:** boşluk, yeni satır, "0" veya özel/matematiksel karakterler yaz.
  - **"0" tuşuna basılı tut, ardından Shift'e bas (Varsayılan: "0" tuşunu basılı tutun, "✱"ye basın):** Para birimi karakterleri yazar.

#### 1-tușu:
- **123 modunda:**
  - **Bas:** "1" yaz.
  - **Basılı tut:** noktalama işaretleri yaz.
- **ABC modunda:**
  - **Bas:** noktalama işaretleri yaz.
  - **Basılı tut:** "1" yaz.
- **Tahmin modunda:**
  - **Bas:** noktalama işaretleri yaz.
  - **Çoklu basış:** emoji yaz.
  - **1-1-3 bas:** özel eklenen emojiyi yaz (bazı emojiler [Kelime Ekle tuşu](#kelime-ekle-tușu) kullanarak eklenmelidir).
  - **Basılı tut:** "1" yaz.
- **Cheonjiin modunda (Korece):**
  - **Bas:** "ㅣ" ünlüsünü yaz.
  - **Basılı tut:** noktalama işaretleri yaz.
  - **Basılı tut, ardından bas:** emoji yaz.
  - **1 basılı tut, ardından 1'e ve 3'e bas:** özel eklenen emojiyi yaz (bazı emojiler [Kelime Ekle tuşu](#kelime-ekle-tușu) kullanarak eklenmelidir).

#### 2-9 tușu:
- **123 modunda:** ilgili sayıyı yaz.
- **ABC ve Tahmin modunda:** bir harf yazın veya basılı tutarak ilgili sayıyı yazın.

### Fonksiyon Tușları

#### Kelime Ekle Tușu:
Mevcut dil için sözlüğe yeni bir kelime ekleyin.

Yeni emojiler de ekleyebilir ve ardından 1-1-3 basarak erişebilirsiniz. Seçili dilden bağımsız olarak, tüm emojiler tüm dillerde kullanılabilir.

#### Silme Tușu (Geri, Sil veya Backspace):
Sadece metni siler.

Telefonunuzda özel bir "Sil" veya "Temizle" tuşu varsa, Ayarlarda bir şey ayarlamanıza gerek yoktur, başka bir Backspace'e sahip olmak istemiyorsanız otomatik olarak boş seçenek: "--" önceden seçilecektir.

"Kombine Geri/Sil" tuşuna sahip telefonlarda bu tuş otomatik olarak seçilecektir. Ancak, "Geri" yalnızca geri gitmek için kullanılması adına başka bir tușu seçebilirsiniz.

_**Not:** "Geri"yi backspace olarak kullanmak tüm uygulamalarda çalışmaz, özellikle Firefox, Spotify ve Termux gibi. Bu uygulamalar tuşun işlevini tamamen yeniden tanımlayabilirler. Maalesef "Geri" Android'de özel bir rol oynar ve sistemi tarafından kullanımı sınırlıdır._

_**Not 2:** "Geri" tuşunu basılı tutmak her zaman varsayılan sistem işlemini tetikleyecektir (örneğin, çalışan uygulamalar listesini gösterir)._

_Bu durumlarda, başka bir tuş atayabilir (tüm diğer tuşlar tam anlamıyla kullanılabilir) veya ekran üzerindeki silme tuşunu kullanabilirsiniz._

#### Sonraki Giriş Modu Tușu (Varsayılan: # bas):
Giriş modlarını değiştirir (abc → Tahmin → 123).

_Tahmin modu parola alanlarında kullanılamaz._

_Sadece sayı alanlarında, mod değiştirme mümkün değildir. Böyle durumlarda, tuş varsayılan işlevine (örneğin "#" yaz) geri döner._

#### Metin Düzenleme Tușu:
Metin düzenleme panelini gösterir, bu panel seçme, kesme, kopyalama ve yapıştırma işlemlerini yapmanıza olanak tanır. Paneli kapatmak için tekrar "✱" tușuna basın veya çoğu uygulamada Geri tușuna basın. Detaylar [aşağıda](#metin-düzenleme) bulunmaktadır.

#### Sonraki Dil Tușu (Varsayılan: # basılı tut):
Ayarlar'dan birden fazla dil etkinleştirildiğinde sonraki dili seçin.

#### Klavye Seç Tușu:
Android Klavye Değiştirme iletişim kutusunu açarak yüklü tüm klavyeler arasında seçim yapabilirsiniz.

#### Shift Tușu (Varsayılan: ✱ bas):
- **Metin yazarken:** Büyük ve küçük harfler arasında geçiş yapın.
- **Özel karakterler yazarken:** 0-tușu ile sonraki karakter grubunu gösterin.

#### Ayarlar Tușu:
Ayarlar yapılandırma ekranını açar. Bu, yazma dillerini seçebileceğiniz, tuş takımı kısayol tușlarını yapılandırabileceğiniz, uygulama görünümünü değiştirebileceğiniz veya telefonunuzla uyumluluğu geliştirebileceğiniz yerdir.

#### Sesli Giriş Tușu:
Desteklenen telefonlarda sesli giriși etkinleştirir. Daha fazla bilgi için [așağıya bakın](#sesli-giriş).

#### Komut Listesi Tușu / Komut Paleti / (Varsayılan: ✱ basılı tut):
Tüm komutları (veya işlevleri) içeren bir liste gösterir.

Birçok telefonda kısayol tuşları için yalnızca iki veya üç "boș" tuş bulunur. Ancak, Traditional T9 daha fazla işlev sunar ve bu, tüm işlevler için tuș takımında yeterli yer olmadığı anlamına gelir. Komut Paleti bu sorunu çözer. Ek işlevleri (veya komutları) tuş kombinasyonlarıyla çağırmanızı sağlar.

İşte olası komutların listesi:
- **Ayarlar Ekranını Göster (Varsayılan Kombinasyon: ✱ basılı tut, 1-tușu).** [Ayarlar Tușu](#ayarlar-tușu)'na basmakla aynıdır.
- **Kelime Ekle (Varsayılan Kombinasyon: ✱ basılı tut, 2-tușu).** [Kelime Ekle Tușu](#kelime-ekle-tușu)'na basmakla aynıdır.
- **Sesli Giriş (Varsayılan Kombinasyon: ✱ basılı tut, 3-tușu).** [Sesli Giriş Tușu](#sesli-giriş-tușu)'na basmakla aynıdır.
- **Metin Düzenle (Varsayılan Kombinasyon: ✱ basılı tut, 5-tușu).** [Metin Düzenleme Tușu](#metin-düzenleme-tușu)'na basmakla aynıdır.
- **Farklı bir Klavye Seç (Varsayılan Kombinasyon: ✱ basılı tut, 8-tușu).** [Klavye Seç Tușu](#klavye-seç-tușu)'na basmakla aynıdır.

_Ekran Düzeni "Sanal Tuș Takımı" olarak ayarlandığında bu tuș hiçbir şey yapmaz çünkü tüm işlevler için tüm tușlar zaten ekranda mevcuttur._

## Sesli Giriş
Sesli giriş işlevi, Gboard'a benzer şekilde konuşmayı metne dönüştürme olanağı sunar. Diğer klavyelerde olduğu gibi, Traditional T9 da kendi başına ses tanıma gerçekleştirmez, ancak telefonunuzdan bunu yapmasını ister.

_Sesli Giriş tușu, bu işlevi desteklemeyen cihazlarda gizlidir._

### Desteklenen Cihazlar
Google Hizmetleri olan cihazlarda, kelimelerinizi metne dönüştürmek için Google Cloud altyapısını kullanır. Bu yöntemin çalışması için bir Wi-Fi ağına bağlanmanız veya mobil veriyi etkinleştirmeniz gerekmektedir.

Google olmayan cihazlarda, eğer cihaz bir sesli asistan uygulamasına sahipse veya yerel klavye sesli giriş desteği sunuyorsa, kullanılabilir olan yöntem ses tanıma için kullanılacaktır. Bu yöntemin Google'dan çok daha sınırlı olduğunu unutmayın. Gürültülü ortamlarda çalışmaz ve genellikle yalnızca "takvimi aç" veya "müzik çal" gibi basit ifadeleri tanır. Avantajı, çevrimdışı olarak çalışabilmesidir.

Google olmayan diğer telefonlar genellikle sesli girişi desteklemeyecektir. Çinli telefonlarda güvenlik politikaları nedeniyle ses tanıma özellikleri bulunmamaktadır. Bu telefonlarda, "com.google.android.googlequicksearchbox" paket adına sahip Google uygulamasını yükleyerek sesli giriş desteğini etkinleştirmek mümkün olabilir.

## Ekran Üzeri Tuș Takımı
Yalnızca dokunmatik ekranlı telefonlarda, tamamen işlevsel bir ekran üstü tuș takımı mevcuttur ve otomatik olarak etkinleșir. Bir şekilde telefonunuzun dokunmatik ekranı olduğunun algılanmadığını düşünüyorsanız, Ayarlar → Görünüm → Ekran Üzeri Düzen yoluyla "Sanal Numpad" seçeneğini etkinleștirin.

Eğer dokunmatik ekranınız ve donanım tuș takımınız varsa ve daha fazla ekran alanına ihtiyaç duyuyorsanız, Ayarlar → Görünüm bölümünden yazılım tușlarını devre dıșı bırakabilirsiniz.

"Geri" tușunun "Geri Sil" olarak özel davranıșını devre dıșı bırakmanız da önerilir. Bu özellik sadece donanım tuș takımı için yararlıdır. Genellikle otomatik olarak da gerçekleșir, ancak olmuyorsa Ayarlar → Tuș Takımı → Kısayol Tușları Seç → Geri Sil tușuna gidin ve "--" seçeneğini seçin.

### Sanal Tușlara Genel Bakış
Ekran klavyesi, fiziksel tuşlara sahip bir telefonun numpad’i ile aynı şekilde çalışır. Bir tuş yalnızca tek bir işlev sağlıyorsa, bu işlevi belirten bir etikete (veya simgeye) sahiptir. Eğer bir tuş, "basılı tutma" yoluyla ikinci bir işlev sağlıyorsa, iki etikete (veya simgeye) sahip olacaktır.

Aşağıda birden fazla işlevi olan tuşların açıklamaları yer almaktadır.

#### Sağ F2 Tuşu (sağ sütundaki en üstten ikinci tuş)
_Yalnızca tahmin modunda._

- **Bas:** Öneri listesini filtreler. Kelime filtrelemenin nasıl çalıştığını görmek için [yukarıdaki](#öneri-filtreleme-tuşu-varsayılan-d-pad-yukarı) açıklamaya bakın.
- **Basılı tut:** Eğer aktifse filtreyi temizler.

#### Sağ F3 Tuşu (sağ sütundaki en üstten üçüncü tuş)
- **Bas:** Kopyalama, yapıştırma ve metin düzenleme seçeneklerini açar.
- **Basılı tut:** Sesli girişi etkinleştirir.

#### Sol F4 tuşu (sol alt köşedeki tuş)
- **Bas:** Giriş modlarını döngüsel olarak değiştirir (abc → Tahmin → 123).
- **Basılı tut:** Ayarlardan birden fazla dil etkinleştirildiğinde bir sonraki dili seçer.
- **Yatay kaydırma:** TT9 dışında kullanılan son klavyeye geçiş yapar.
- **Dikey kaydırma:** Tüm yüklü klavyeler arasından seçim yapabileceğiniz Android Klavye Değiştirme diyalog penceresini açar.

_Ayarlar → Diller kısmından birden fazla dili etkinleştirdiyseniz, tuşta küçük bir küre simgesi görüntülenir. Simge, tuşu basılı tutarak dil değiştirebileceğinizi gösterir._

### Yazarken Klavye Panelini Yeniden Boyutlandırma
Bazı durumlarda, Sanal Tuș Takımının çok fazla ekran alanı kapladığını, yazdıklarınızı veya bazı uygulama öğelerini göremediğinizi fark edebilirsiniz. Bu durumda, Ayarlar/Komut Paleti tușunu basılı tutarak veya Durum Çubuğunu (mevcut dil veya yazma modunun gösterildiği alan) sürükleyerek yeniden boyutlandırabilirsiniz. Yükseklik çok küçük hale geldiğinde, düzen otomatik olarak "İşlev tușları" veya yalnızca "Öneri listesi" olarak değișecektir. Yukarı doğru yeniden boyutlandırdığınızda ise düzen "Sanal Tuș Takımı"na geçer. Durum çubuğuna iki kez dokunarak hızlıca minimize veya maximize edebilirsiniz.

_Traditional T9'u yeniden boyutlandırmak, aynı zamanda mevcut uygulamanın yeniden boyutlandırılmasına neden olur. Her ikisini birden yapmak hesaplama açısından oldukça maliyetlidir. Birçok telefonda, hatta üst düzey olanlarda bile titreme veya takılma olabilir._

### Tuș Yüksekliğini Değiștirme
Ekran üzerindeki tuș yüksekliğini de değiștirmek mümkündür. Bunu yapmak için Ayarlar → Görünüm → Ekran Üzeri Tuș Yüksekliği bölümüne gidin ve istediğiniz gibi ayarlayın.

Varsayılan ayar olan %100, kullanılabilir tuș boyutu ve kapladığı ekran alanı arasında iyi bir denge sağlar. Ancak, büyük parmaklarınız varsa ayarı biraz artırmak isteyebilir veya TT9'u daha büyük ekranlarda (örneğin bir tablette) kullanıyorsanız ayarı azaltmak isteyebilirsiniz.

_Eğer mevcut ekran alanı sınırlıysa, TT9 bu ayarı göz ardı edecek ve yüksekliğini otomatik olarak azaltarak mevcut uygulama için yeterli alan bırakacaktır._

## Metin Düzenleme
Metin Düzenleme panelinden, bilgisayar klavyesinde olduğu gibi metni seçebilir, kesebilir, kopyalayabilir ve yapıştırabilirsiniz. Metin Düzenlemeyi kapatmak için "✱" tușuna veya Geri tușuna basın (web tarayıcıları, Spotify ve bazı diğer uygulamalar hariç). Ekran Üzeri Klavyede ise harfler tușuna basabilirsiniz.

Așağıda olası metin komutlarının bir listesi bulunmaktadır:
1. Önceki karakteri seç (bilgisayar klavyesinde Shift+Sol gibi)
2. Seçimi iptal et
3. Sonraki karakteri seç (Shift+Sağ gibi)
4. Önceki kelimeyi seç (Ctrl+Shift+Sol gibi)
5. Tümünü seç
6. Sonraki kelimeyi seç (Ctrl+Shift+Sağ gibi)
7. Kes
8. Kopyala
9. Yapıștır

Daha kolay düzenleme için geri sil, boşluk ve Tamam tușları da aktiftir.

## Ayarlar Ekranı
Ayarlar ekranında, yazma dillerini seçebilir, tuș takımı kısayol tușlarını yapılandırabilir, uygulama görünümünü değiştirebilir veya telefonunuzla uyumluluğu geliştirebilirsiniz.

### Ayarlara Nasıl Erişilir?

#### Yöntem 1
Traditional T9 kısayol simgesine tıklayın.

#### Yöntem 2 (dokunmatik ekran kullanarak)
- TT9'u uyandırmak için bir metin veya sayı alanına dokunun.
- Ekrandaki ayar simgesine dokunun.

#### Yöntem 3 (donanım klavyesi kullanarak)
- Bir metin veya sayı alanında yazmaya başlayarak TT9'u uyandırın.
- Ekran üzerindeki araçlar tușuna veya atanmış kısayola basarak komut listesini açın [Varsayılan: ✱ basılı tutun].
- 2-tușuna basın.

### Ayarlarda Gezinme
Donanım tuș takımına sahip bir cihazınız varsa, Ayarlar’da gezinmenin iki yolu vardır.

1. Kaydırma için Yukarı/Așağı tușlarını kullanın ve bir seçenek açmak veya etkinleştirmek için Tamam tușuna basın.
2. İlgili seçeneği seçmek için 1-9 tușlarına basın ve açmak/etkinleştirmek için iki kez basın. Nerede olursanız olun çift basış işe yarayacaktır. Örneğin, ekranın en üstündeyken bile 3-tușuna iki kez basarsanız üçüncü seçenek etkinleșir. Son olarak, 0-tușu sona kaydırma için bir kısayol işlevi görür ancak son seçeneği açmaz.

### Dil Seçenekleri

#### Bir Sözlük Yüklemek
Bir veya daha fazla dili etkinleștirdikten sonra, Tahmin Modu için ilgili sözlükleri yüklemelisiniz. Bir kez yüklendiğinde, sözlük silme seçeneklerinden birini kullanmadığınız sürece orada kalacaktır. Bu, dilleri yeniden etkinleştirip devre dıșı bırakırken sözlükleri her seferinde yeniden yüklemenize gerek olmadığı anlamına gelir. Sadece bir kez yapın, yalnızca ilk defa.

Bu aynı zamanda, X dilini kullanmaya başlamanız gerektiğinde, diğer tüm dilleri güvenle devre dıșı bırakabileceğiniz anlamına gelir; yalnızca X dilini yükleyin (ve zamandan tasarruf edin!), ardından daha önce kullandığınız tüm dilleri yeniden etkinleştirin.

Bir sözlüğü yeniden yüklemek öneri popülerliğini fabrika ayarlarına sıfırlayacaktır. Ancak, endișe etmenizi gerektiren bir durum yoktur. Çoğunlukla seçtiğiniz kelime tam olarak önerilecektir.

#### Otomatik Sözlük Yükleme

Ayarlar ekranından bir sözlük yüklemeyi atlarsanız veya unutursanız, yazı yazabileceğiniz bir uygulamaya gidip Tahmin Moduna geçtiğinizde otomatik olarak yüklenecektir. Yükleme tamamlanana kadar beklemeniz istenecek ve ardından yazmaya başlayabilirsiniz.

Bir veya daha fazla sözlüğü sildiğinizde, bunlar otomatik olarak yeniden yüklenmez. Bunu manuel olarak yapmanız gerekecektir. Sadece yeni etkinleştirilen dillerin sözlükleri otomatik olarak yüklenecektir.

#### Bir Sözlüğü Silme
X veya Y dillerini kullanmayı bıraktıysanız, bunları devre dışı bırakabilir ve depolama alanını boşaltmak için "Seçilmeyenleri Sil" seçeneğini kullanabilirsiniz.

Her şeyi seçiminize bakılmaksızın silmek için "Hepsini Sil" seçeneğini kullanın.

Her durumda, eklediğiniz özel kelimeler korunacak ve ilgili sözlüğü yeniden yüklediğinizde geri yüklenecektir.

#### Eklenen Kelimeler
"Export" seçeneği, eklediğiniz tüm kelimeleri, eklenen emojiler dahil olmak üzere, tüm diller için bir CSV dosyasına dışa aktarmanıza olanak tanır. Ardından bu CSV dosyasını Traditional T9'u iyileştirmek için kullanabilirsiniz! GitHub'a gidip kelimeleri [yeni bir konu](https://github.com/sspanak/tt9/issues) veya [pull request](https://github.com/sspanak/tt9/pulls) açarak paylaşabilirsiniz. Gözden geçirildikten ve onaylandıktan sonra bir sonraki sürüme ekleneceklerdir.

"Import" ile daha önce dışa aktardığınız bir CSV'yi içe aktarabilirsiniz. Ancak bazı kısıtlamalar vardır:
- Yalnızca harflerden oluşan kelimeleri içe aktarabilirsiniz. Kesme işaretleri, kısa çizgiler, diğer noktalama işaretleri veya özel karakterler kabul edilmez.
- Emojiler kabul edilmez.
- Bir CSV dosyası en fazla 250 kelime içerebilir.
- En fazla 1000 kelime içe aktarabilirsiniz; yani en fazla 4 dosya X 250 kelime içe aktarabilirsiniz. Bu sınırdan sonra, yazarken yine de kelime ekleyebilirsiniz.

"Delete" seçeneğini kullanarak yanlış yazılmış veya sözlükte bulunmasını istemediğiniz kelimeleri arayıp silebilirsiniz.

### Uyumluluk Seçenekleri
Bazı uygulama veya cihazlar için, Traditional T9'un bunlarla daha iyi çalışmasını sağlayacak özel seçenekleri etkinleştirmek mümkündür. Her ayar ekranının sonunda Uyumluluk bölümünde bulabilirsiniz.

#### Alternatif öneri kaydırma yöntemi
_Ayarlar → Görünüm altında._

Bazı cihazlarda, Tahmin Modunda, listeyi sonuna kadar kaydıramayabilir veya son öneri görünene kadar birkaç kez ileri geri kaydırmanız gerekebilir. Bu sorun bazen Android 9 veya daha eski sürümlerde meydana gelir. Bu sorunu yaşıyorsanız, bu seçeneği etkinleştirin.

#### Her Zaman Üstte
_Ayarlar → Görünüm altında._

Bazı telefonlarda, özellikle Sonim XP3plus (XP3900) modelinde, Traditional T9 yazmaya başladığınızda görünmeyebilir veya yumuşak tuşlarla kısmen örtülebilir. Diğer durumlarda, etrafında beyaz çubuklar olabilir. Sorunu önlemek için "Her Zaman Üstte" seçeneğini etkinleştirin.

#### Tuş tekrarı koruması
_Ayarlar → Tuş Takımı altında._

CAT S22 Flip ve Qin F21 telefonları, zamanla hızla bozulup tek bir tuşa basış için birden çok tıklama kaydeden düşük kaliteli tuş takımlarına sahip olmalarıyla bilinir. Bu, yazarken veya telefon menülerinde gezinirken fark edilebilir.

CAT telefonlar için önerilen ayar 50-75 ms’dir. Qin F21 için 20-30 ms ile başlayın. Sorun devam ediyorsa değeri biraz artırın, ancak genel olarak mümkün olduğunca düşük tutmaya çalışın.

_**Not:** Değer ne kadar yüksek olursa, yazmanız o kadar yavaş olur. TT9 çok hızlı tuş basışlarını görmezden gelecektir._

_**Not 2:** Yukarıdakilere ek olarak, Qin telefonları bazen uzun basışları algılayamayabilir. Bu durumda maalesef yapılabilecek bir şey yoktur._

#### Telegram/Snapchat sticker ve emoji panelleri açılmıyor
Bu, küçük boyutlu düzenlerden birini kullanıyorsanız gerçekleşir. Şu an için kalıcı bir çözüm yok, ancak şu geçici çözümü kullanabilirsiniz:
- Ayarlar → Görünüm yoluna gidin ve Ekran Üzeri Numpad'i etkinleştirin.
- SoHBETe geri dönün ve emoji veya sticker butonuna tıklayın. Artık görünecekler.
- Ayarlara geri dönüp ekran üzeri numpadi devre dışı bırakabilirsiniz. Emoji ve sticker panelleri, uygulamayı veya telefonu yeniden başlatana kadar erişilebilir durumda kalacaktır.

#### Traditional T9 bazı uygulamalarda hemen görünmüyor
Yazabileceğiniz bir uygulamayı açtıysanız ancak TT9 otomatik olarak görünmüyorsa, yazmaya başlayın, ortaya çıkacaktır. Alternatif olarak, [giriş modunu değiştirmek](#sonraki-giriş-modu-tușu-varsayılan-bas) veya [dil değiştirmek](#sonraki-dil-tușu-varsayılan-basılı-tut) için kısayol tuşlarına basmak TT9'u ortaya çıkarmaya yardımcı olabilir.

Bazı cihazlarda TT9 görünmez kalabilir, ne yaparsanız yapın. Bu durumda, [Her Zaman Üstte](#her-zaman-üstte) seçeneğini etkinleştirmeniz gerekir.

**Uzun açıklama:** Bu sorunun nedeni, Android'in öncelikle dokunmatik ekranlı cihazlar için tasarlanmış olmasıdır. Bu nedenle, klavyeyi göstermek için metin/sayı alanına dokunmanızı bekler. TT9'u bu onayı almadan görünür hale getirmek mümkün, ancak o zaman Android bazen gizlemeyi unutabilir. Örneğin, bir telefon numarası çevirdiğinizde veya bir arama alanına metin girdikten sonra klavye açık kalabilir.

Bu nedenlerden dolayı, Android standartlarına uygun kalmak için kontrol sizin elinizde. Ekrana "dokunmak" için bir tuşa basın ve yazmaya devam edin.

#### Qin F21 Pro'da 2 veya 8 tuşuna basılı tutmak, sayı yazmak yerine sesi açıyor veya kısıyor
Bu sorunu hafifletmek için Ayarlar → Görünüm yoluna gidin ve "Durum Simgesi"ni etkinleştirin. TT9, Qin F21'i otomatik olarak algılamalı ve ayarları etkinleştirmelidir, ancak otomatik algılama başarısız olursa veya simgeyi bir nedenle devre dışı bıraktıysanız, tüm tuşların düzgün çalışması için simgeyi etkinleştirmeniz gerekir.

**Uzun açıklama:** Qin F21 Pro (ve muhtemelen F22), numara tuşlarına Ses Aç ve Ses Kıs işlevlerini atama olanağı sunan bir kısayol uygulamasına sahiptir. Varsayılan olarak, kısayol yöneticisi etkinleştirilmiştir ve 2 tuşuna basılı tutmak sesi artırır, 8 tuşuna basılı tutmak ise sesi kısar. Ancak, durum simgesi yoksa, yönetici etkin bir klavye olmadığını varsayar ve ses seviyesini ayarlar; bu durumda, Traditional T9 tuşu kullanamaz ve bir sayı yazamaz. Simgeyi etkinleştirmek, kısayol yöneticisini atlayarak her şeyin sorunsuz çalışmasını sağlar.

#### Xiaomi telefonlarda genel sorunlar
Xiaomi, telefonlarında Traditional T9'un sanal ekran klavyesinin düzgün çalışmasını engelleyen bir dizi standart dışı izin tanıtmıştır. Daha spesifik olarak, "Ayarları Göster" ve "Kelime Ekle" tuşları, ilgili işlevlerini yerine getiremeyebilir. Bunu düzeltmek için TT9'a telefonunuzun ayarlarından "Ekran pop-up penceresi göster" ve "Arka planda çalışırken ekran pop-up penceresi göster" izinlerini vermelisiniz. [Bu rehber](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi), başka bir uygulama için nasıl yapılacağını anlatıyor.

"Açık bildirim" iznini vermek de şiddetle tavsiye edilir. Bu, Android 13'te tanıtılan "Bildirimler" iznine benzer. Neden gerektiği konusunda daha fazla bilgi için [yukarıya bakın](#android-13-veya-üstü-için-notlar).

_Xiaomi sorunları [bu GitHub sorununda](https://github.com/sspanak/tt9/issues/490) tartışılmıştır._

#### Sesli Giriş'in durması çok uzun sürüyor
Bu, Android 10'da Google'ın asla düzeltmediği [bilinen bir sorun](https://issuetracker.google.com/issues/158198432). TT9 tarafında hafifletmek mümkün değildir. Sesli Giriş işlemini durdurmak için birkaç saniye sessiz kalın. Android, herhangi bir konuşma algılamadığında mikrofonu otomatik olarak kapatır.

## Sıkça Sorulan Sorular

#### Özellik X'i ekleyemez misiniz?
Hayır.

Herkesin kendi tercihleri vardır. Kimisi daha büyük tuşlar ister, kimisi farklı bir düzen, kimisi ".com" yazmak için bir kısayol tuşu ister ve kimisi de eski telefonunu veya klavyesini özler. Ancak lütfen anlayın ki, bu projeyi boş zamanlarımda gönüllü olarak yürütüyorum. Birbirleriyle çelişen binlerce farklı isteği yerine getirmek imkansızdır.

Henry Ford bir keresinde şöyle demiştir: "Müşteri istediği herhangi bir rengi seçebilir, yeter ki siyah olsun." Benzer şekilde, Traditional T9 sade, etkili ve ücretsizdir; ne alıyorsanız onu kullanırsınız.

#### Neden Sony Ericsson, Xperia, Nokia C2, Samsung veya başka bir yazılım klavyesine daha çok benzetmiyorsunuz?
Hayır.

Traditional T9, bir kopya uygulama ya da eski bir klavyenin birebir ikamesi olmak için tasarlanmadı. Kendine özgü bir tasarımı vardır ve temel olarak Nokia 3310 ve 6303i modellerinden ilham almıştır. Klasik telefonların hissini verse de, tam olarak hiçbir cihazı taklit etmez.

#### Touchpal'ı kopyalamalısınız, o dünyanın en iyi klavyesi!
Hayır, kopyalamamalıyım. Önceki maddelere bakın.

Touchpal, 2015 yılında rakipsiz olduğu dönemde gerçekten en iyi klavyelerden biriydi. Ancak o zamandan beri işler değişti. İşte Traditional T9 ve Touchpal'ın karşılaştırması:

_**Traditional T9**_
- Gizliliğinize saygı duyar.
- Reklam içermez ve tamamen ücretsizdir.
- Geniş bir cihaz yelpazesini destekler: tuşlu telefonlar, donanım klavyeli televizyonlar ve yalnızca dokunmatik ekrana sahip akıllı telefonlar ve tabletler.
- Her dil için tam uyumlu 12 tuşlu bir T9 düzeni sunar.
- Gelişmiş kelime önerileri sağlar. Örneğin, "go in" gibi bir textonym ifadesi yazmaya çalışırsanız, "go go" veya "in in" yerine anlamlı olan ifadeyi öğrenerek önerir.
- Yazdığınız her şey cihazınızda kalır. Hiçbir veri herhangi bir yere gönderilmez.
- Açık kaynaklıdır, böylece tüm kaynak kodunu ve sözlükleri inceleyebilir, projeye katkıda bulunarak geliştirebilir (birçok kullanıcı hataları düzeltmeye ve yeni diller ile çeviriler eklemeye yardımcı oldu) veya kendi isteğinize göre bir mod oluşturabilirsiniz.
- Sisteme uyum sağlayan sade ve okunaklı bir tasarıma sahiptir. Gereksiz süslemeler içermez, böylece yazmaya odaklanabilirsiniz.
- Sözlük yükleme hızı düşüktür.

_**Touchpal**_
- Cihazınızdaki tüm verilere ve kişilerinize erişmek için ısrarcıdır; rastgele dosyalar oluşturur; en sonunda bir virüs gibi davrandığı için Play Store'dan kaldırılmıştır.
- Reklamlarla doludur.
- Sadece dokunmatik ekranlı cihazları destekler.
- Gerçek bir T9 klavyesi değildir. Yalnızca bazı dillerde T9 düzeni sunar. Ayrıca, bazı düzenler hatalıdır (örneğin, Bulgarca'da bir harf eksik ve bazı harfler 8 ve 9 tuşları arasında yanlış sıralanmıştır).
- Arka arkaya textonym yazarken yalnızca son seçtiğiniz kelimeyi önerir. Örneğin, "go in" yazmaya çalıştığınızda, ya "go go" ya da "in in" şeklinde önerir.
- Bulut tabanlı öneriler doğruluğu artırabilir, ancak bunun çalışması için sizin ve diğer tüm kullanıcıların yazdıkları her şeyi Touchpal sunucularına göndermesi gerekir.
- Kapalı kaynaklıdır. Arka planda ne yaptığını kontrol etmenin hiçbir yolu yoktur.
- Klavyeyle ilgisi olmayan birçok tema, renk, GIF ve dikkat dağıtıcı unsur içerir.
- Sözlük yükleme hızı yüksektir. Bu noktada Touchpal kazanıyor.

Eğer aynı fikirde değilseniz veya bakış açınızı açıklamak isterseniz, GitHub'daki [açık tartışmaya](https://github.com/sspanak/tt9/issues/647) katılabilirsiniz. Sadece diğer kullanıcılara saygılı olun. Nefret içerikli mesajlara izin verilmeyecektir.

#### QWERTY Düzeni Kullanmak İstiyorum (yalnızca dokunmatik ekran cihazları)
Traditional T9, bir T9 klavyesidir ve bu nedenle QWERTY benzeri bir düzen sağlamaz.

T9 kullanmayı öğreniyorsanız ve ara sıra geri dönmeniz gerekiyorsa veya yeni kelimeleri QWERTY ile yazmak daha uygun geliyorsa, farklı bir klavyeye geçmek için Sol F4 tuşuna yukarı kaydırabilirsiniz. Daha fazla bilgi için [sanal tuşlar genel bakışına](#sanal-tușlara-genel-bakış) bakın.

Çoğu diğer klavye, space tuşuna veya "dil değiştirme" tuşuna basılı tutarak tekrar Traditional T9'a geçiş yapmanıza izin verir. İlgili kılavuz veya kullanım kılavuzuna göz atın.

#### Dokunmatik ekranlı bir telefonda dili değiştiremiyorum
Öncelikle Ayarlar → Diller kısmından tüm istediğiniz dilleri etkinleştirdiğinizden emin olun. Ardından, dili değiştirmek için [Sol F4 tuşunu](#sol-f4-tuşu-sol-alt-köşedeki-tuş) basılı tutun.