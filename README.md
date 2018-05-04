# KÜTÜPHANEYİ PROJEYE EKLEME

ekomesajapi klasörünü proje dosyanızın bulunduğu dizinin içine atınız.

### settings.gradle dosyasına aşağıdaki kodu ekleyin 
```java
include ':app', ':ekomesajapi'
```

### build.gradle dosyasına dependecies kısmına aşağıdaki kodu ekleyin 
```java
compile project(path: ':ekomesajapi')
```

# SUBMIT METODU
```java
// SUBMIT
// Birden çok numraya aynı mesaj içeriği gönderilmesini sağlar.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

Submit submit = new Submit();

// header objesi başlık, ileri tarihli gönderim, geçerlilik süresi
Header header = new Header();

//Gönderen Adı / Başlık / [ZORUNLU]
header.setFrom("TESTSENDER");

//İleri tarihli gönderim yapılmak isteniyorsa girilmelidir. / [OPSİYONEL]
header.setScheduledDeliveryTime("2018-08-20T12:15:00Z");

//mesaj gönderimi başarısız ise 1440 dk boyunca tekrar denenecek ve bu süre sonunda artık gönderim denenmeyecektir.
//Bu alan gönderilmez veya 0 gönderilirse default değeri 1440 olarak alır.
//[OPSİYONEL]
header.setValidityPeriod(0);

submit.setHeader(header);

// Mesajın kodlanma biçimidir.
submit.setDataCoding(DataCoding.Default);

// gönderilecek mesaj içeriği / [ZORUNLU]
submit.setMessage("Test Message");

// telefon numaraları / [ZORUNLU]
ArrayList<String > arrayList = new ArrayList<>();
arrayList.add("905998887766");
arrayList.add("905998887755");
arrayList.add("905998887744");
submit.setTo(arrayList);

// RequestSubmit'e ilgili değişkenleri atayıp PostSubmit metodun ile mesajımızı gönderiyoruz.
RequestSubmit requestSubmit = new RequestSubmit(credential, submit);
new PostSubmit(requestSubmit, new RequestListener<ResponseSubmit>() {
    @Override
    public void onTaskComplete(ResponseSubmit response) {
        if(response.getStatus().getCode() == 200){
            System.out.println("MessageId: " + response.getMessageId());
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////
// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// MessageId
// Sistemden rapor alınması için geri dönen mesaj numarasıdır.
```

# SUBMITMULTI METODU
```java
// SUBMITMULTI
// Birden çok numraya farklı mesaj içeriği gönderilmesini sağlar.
// Birden çok numaraya aynı içerik göndermek için SUBMIT kullanmanız gerekir.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

SubmitMulti submitMulti = new SubmitMulti();

// header objesi başlık, ileri tarihli gönderim, geçerlilik süresi
Header header = new Header();

//Gönderen Adı / Başlık / [ZORUNLU]
header.setFrom("TESTSENDER");

//İleri tarihli gönderim yapılmak isteniyorsa girilmelidir. / [OPSİYONEL]
header.setScheduledDeliveryTime("2018-08-20T12:15:00Z");

//mesaj gönderimi başarısız ise 1440 dk boyunca tekrar denenecek ve bu süre sonunda artık gönderim denenmeyecektir.
//Bu alan gönderilmez veya 0 gönderilirse default değeri 1440 olarak alır.
//[OPSİYONEL]
header.setValidityPeriod(0);

submitMulti.setHeader(header);

// Mesajın kodlanma biçimidir.
submitMulti.setDataCoding(DataCoding.Default);

// telefon numaraları ve mesajlar / [ZORUNLU]
ArrayList<Envelopes> arrayList = new ArrayList<>();
arrayList.add(new Envelopes("905998887766", "Test Message 1"));
arrayList.add(new Envelopes("905998887755", "Test Message 2"));
submitMulti.setEnvelopes(arrayList);

RequestSubmitMulti requestSubmitMulti = new RequestSubmitMulti(credential, submitMulti);
new PostSubmitMulti(requestSubmitMulti, new RequestListener<ResponseSubmitMulti>() {
    @Override
    public void onTaskComplete(ResponseSubmitMulti response) {
        if(response.getStatus().getCode() == 200){
            System.out.println("MessageId: " + response.getMessageId());
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// MessageId
// Sistemden rapor alınması için geri dönen mesaj numarasıdır.
```

# QUERYSTATS METODU
```java
// QUERYSTATS
// Aylık ve Yıllık teslimat rapor bilgilerini verir.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

// PostQueryStats metodun ile Asycn Olarak raporlarımızı çekiyoruz.
new PostQueryStats(credential, new RequestListener<ResponseQueryStats>() {
    @Override
    public void onTaskComplete(ResponseQueryStats response) {
        if(response.getStatus().getCode() == 200){
            for(QueryStats queryStats : response.getQueryStatsList()){
                String temp = "Year: " + queryStats.getYear() + " Month: " + queryStats.getMonth()
                            + " Delivered: " + queryStats.getDelivered() + " Undelivered: " + queryStats.getUndelivered()
                            + " Count: " + queryStats.getCount();
                System.out.println(temp);
            }
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// QueryStats
// Count:              Toplam gönderilen mesaj sayısı.
// Delivered:          Teslim edilen mesaj sayısı.
// UndeliveredCount:   Teslim edilemeyen mesaj sayısı.
// Month:              Rapor ay bilgisi.
// Year:               Rapor yıl bilgisi.
```

# QUERY METODU
```java
// QUERY
// MessageId veya MessageId + Telefon numarasına göre raporlama yapmanızı sağlar.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

// messageId / [ZORUNLU]
String messageId = "367574651";

// ilgili pakette belirli bir numaranın raporlanması isteniyorsa girilir [OPSİYONEL]
String phoneNumber = "";

RequestQuery requestQuery = new RequestQuery(credential, messageId, phoneNumber);
new PostQuery(requestQuery, new RequestListener<ResponseQuery>() {
    @Override
    public void onTaskComplete(ResponseQuery response) {
        if(response.getStatus().getCode() == 200){
            for(Query query : response.getQueryList()){
                System.out.println("Id: " + query.getId() + " Network: " + query.getNetwork() + " MSISDN: " + query.getMsisdn()
                        + " Cost: " + query.getCost() + " Submitted: " + query.getSubmitted() + " LastUpdate: " + query.getLastUpdate()
                        + " State: " + query.getState() + " Sequence: " + query.getSequence() + " ErrorCode: " + query.getErrorCode()
                        + " PayLoad: " + query.getPayLoad() + " Xser: " + query.getXser());
            }
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// Query
// Payload:    Mesaj içeriği.
// Xser:       UCP XSER değeri veya UDH SMPP değeri.
// Cost:       Mesaj ücreti.
// ErrorCode:  Hata kodu. Mesaj gönderiminde problem olursa bu alanda hata kodu döner.
// Id:         Bir pakette birden fazla veya tek mesaj bulunabilir. Mesajın paket içerisindeki Id numarasıdır.
// LastUpdated:Durum güncellemesinin yapıldığı son tarih. (UTC Time Zone)
// MSISDN:     Gönderilen telefon numarası.
// Network:    Mesajın gönderildiği operatör Id'si.
// Sequence:   Uzun/Birleşik mesajlarda burada her mesajın içeriği listelenir.
// State:      Mesaj durumu.
// Submitted:  Mesajın sisteme teslim edilme zamanıdır. (UTC Time Zone)
```


# QUERYMULTI METODU
```java
// QUERYMULTI
// Tarih aralığına göre raporlama yapmanızı sağlar.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

// Başlangıç Tarihi / [ZORUNLU]
String beginDate = "2018-03-01T00:00:00";

// Bitiş Tarihi / [ZORUNLU]
String endDate = "2018-03-06T00:00:00";

RequestQueryMulti requestQueryMulti = new RequestQueryMulti(credential, beginDate, endDate);
new PostQueryMulti(requestQueryMulti, new RequestListener<ResponseQueryMulti>() {
    @Override
    public void onTaskComplete(ResponseQueryMulti response) {
        if(response.getStatus().getCode() == 200){
            for(QueryMulti queryMulti : response.getQueryMultiList()){
                System.out.println("Coding: " + queryMulti.getCoding() + " Cost: " + queryMulti.getCost()
                        + " Count: " + queryMulti.getCount() + " Id: " + queryMulti.getId() + " Message: " + queryMulti.getMessage()
                        + " Received: " + queryMulti.getReceived() + " Sender: " + queryMulti.getSender() + " Sent: " + queryMulti.getSent()
                        + " State: " + queryMulti.getState() + " DeliveredCount: " + queryMulti.getDeliveredCount()
                        + " UndeliveredCount: " + queryMulti.getUndeliveredCount());
            }
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// QueryMulti
// Cost:            Mesaj ücreti.
// Count:           Toplam mesaj sayısı.
// DeliveredCount:  Teslim edilen mesaj sayısı.
// UndeliveredCount:Teslim edilemeyen mesaj sayısı.
// Id:              Mesaj paket numarasıdır.
// Message:         Mesaj içeriği.
// Received:        Sistemin mesajı aldığı tarih. (UTC Time Zone)
// Sender:          Mesajı gönderen alfanumerik isim.
// Sent:            Mesajı gönderilme tarihi. (UTC Time Zone)
// State:           Mesaj paketinin durumu. Mesaj Paket Durumları
// Coding:          Mesajın kodlanma biçimidir. 3 değer alabilir;
```

# GETBALANCE METODU
```java
// GETBALANCE
// Kredi durumunuzu gösterir.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

new PostBalance(credential, new RequestListener<ResponseBalance>() {
    @Override
    public void onTaskComplete(ResponseBalance response) {
        if(response.getStatus().getCode() == 200){
            System.out.println("Main: " + response.getBalance().getMain() + "Limit: " + response.getBalance().getLimit());
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// Main:    Ana Kredi. Sahip olduğunuz kredi adetidir.
// Limit:   Eksiye düşebileceğiniz kredi adetidir.
// Kullanılabilir Kredi:    total = main + limit;
```

# LOGİN METODU
```java
// LOGIN
// Kullanıcının kullanıcı adı ve parolasını doğrular.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

new PostLogin(credential, new RequestListener<ResponseLogin>() {
    @Override
    public void onTaskComplete(ResponseLogin response) {
        if(response.getStatus().getCode() == 200){
            System.out.println("UserId: " + response.getUserId());
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

// Status.
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// UserId:    Ana Kredi. Sahip olduğunuz kredi adetidir.
```

# GETSETTINGS METODU
```java
// GETSETTINGS
// Hesabınız ile ilgili bilgileri almanızı sağlar.

// credential objesi API'ye ulaşabilmeniz için gerekli kullanıcı doğrulamasının yapıldığı alandır.
Credential credential = new Credential("username", "password");

new PostSettings(credential, new RequestListener<ResponseSetting>() {
    @Override
    public void onTaskComplete(ResponseSetting response) {
        if(response.getStatus().getCode() == 200){
            OperatorSettings opeSet = response.getSettings().getOperatorSettings();
            System.out.println("Account: " + opeSet.getAccount() + " MSISDN: " + opeSet.getMsisdn()
                    + " VariantId: " + opeSet.getVariantId() + " ServiceId: " + opeSet.getServiceId()
                    + " UnitPrice: " + opeSet.getUnitPrice());

            Balance balance = response.getSettings().getBalance();
            System.out.println("Main: " + balance.getMain() + "Limit: " + balance.getLimit());

            ArrayList<Sender> senders = response.getSettings().getSenders();
            for (int i = 0; i < senders.size(); i++) {
                System.out.println("Value: " + senders.get(i).getValue() + " Default: " + senders.get(i).getDefault());
            }

            ArrayList<Keyword> keywords = response.getSettings().getKeywords();
            for (int i = 0; i < keywords.size(); i++) {
                System.out.println("ServiceNumber: " + keywords.get(i).getServiceNumber()
                        + " Value " + keywords.get(i).getValue() + " Timestamp: " + keywords.get(i).getTimeStamp()
                        + " Validity: " + keywords.get(i).getValidity());
            }
        }else{
            System.out.println("Code: " + response.getStatus().getCode() + " Description: " + response.getStatus().getDescription());
        }
    }
}).execute();

/////////////////////////////////////////
// gelen cevaplar ve anlamları.
/////////////////////////////////////////

// Status
// Code ve Desc alanları yer alır. Mesajın sisteme başarılı şekilde gönderilip gönderilmediği bilgisini verir.
// Code = 200 ve Description = OK ise mesaj sisteme başarılı şekilde ulaşmıştır. Bu mesajın iletim durumu değildir.
// Alabileceği değerler için dokümana bakınız.

// Balance
// Main:    Ana Kredi. Sahip olduğunuz kredi adetidir.
// Limit:   Eksiye düşebileceğiniz kredi adetidir.
// Kullanılabilir Kredi:    total = main + limit;

// Keyword
// ServiceNumber:   Servis numarası.
// Validity:        Geçerlilik süresi.
// Timestamp:       Zaman damgası.
// Value:           Servis numarasında kullanılacak SMS anahtar kelimesi.

// Sender
// Default:   Varsayılan başlık olup olmadığı bilgisidir. True (Evet) ve False (Hayır) değerleri alabilir.
// Value:     Gönderen başlığı.

// OperatorSettings
// Account:      Hesap tipiniz. Postpaid (Faturalı) ve Prepaid (Ön Ödemeli) değerleri alabilir.
// MSISDN:       Hesabınıza atanmış telefon varsa bu alanda gelir.
// ServiceId:    Servis numarası.
// UnitPrice:    Hesabınıza atanmış birim fiyat varsa bu alanda gelir.
// VariantId:    Varyant Id'si.
```

