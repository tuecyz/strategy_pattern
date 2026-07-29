Bu proje, Strategy Design Pattern'ın Spring Boot kullanılarak gerçek hayata yakın bir senaryoda uygulanmasını göstermek amacıyla geliştirilmiştir. Örnek olarak bir ödeme sistemi ele alınmış ve farklı ödeme yöntemleri (Kredi Kartı, Banka Havalesi, Papara ve Kripto) birbirinden bağımsız stratejiler olarak tasarlanmıştır. Bu sayede yeni bir ödeme yöntemi eklenirken mevcut iş kurallarının değiştirilmesine gerek kalmadan sistem genişletilebilir. Proje, Strategy Pattern'ın kullanımını, Spring'in bağımlılık enjeksiyonu (Dependency Injection) mekanizmasıyla birlikte göstermeyi ve temiz kod ile SOLID prensiplerine uygun bir mimari sunmayı amaçlamaktadır.

Strategy Pattern Nedir?
Strategy Pattern, bir tasarım desenidir. Bir işlemin farklı gerçekleştirilme biçimlerini ayrı sınıflar halinde tanımlayarak, çalışma anında (runtime) uygun algoritmanın seçilmesini sağlar.
Bu yaklaşım sayesinde her algoritma kendi sınıfında izole edilir ve client hangi algoritmanın kullanılacağını detaylarını bilmeden çalışabilir. Böylece kod daha esnek, okunabilir ve genişletilebilir hale gelir.

Bu projede her ödeme yöntemi (Kredi Kartı, Banka Havalesi, Papara ve Kripto) farklı bir strateji olarak modellenmiştir ve tüm stratejiler PaymentStrategy arayüzünü uygulamaktadır.

Bu Projede Neden Kullanıldı?
Bir e-ticaret sisteminde farklı ödeme yöntemleri farklı iş kurallarına sahiptir. Örneğin;

Kredi kartı ödemesinde kart doğrulama yapılabilir.
Banka havalesinde IBAN kontrolü gerçekleştirilebilir.
Papara ödemesinde kullanıcı bakiyesi sorgulanabilir.
Kripto ödemesinde cüzdan adresi doğrulanabilir.

Bu işlemleri tek bir servis içerisinde if-else veya switch bloklarıyla yönetmek yerine, her ödeme yöntemi kendi strateji sınıfına taşınmıştır.

Böylece:

Her sınıf yalnızca kendi ödeme sürecinden sorumludur.
Kod tekrarının önüne geçilir.
Yeni ödeme yöntemleri kolayca eklenebilir.
Kodun okunabilirliği ve bakım kolaylığı artar.
Open/Closed Principle uygulanmış olur.

Strategy Pattern Kullanılmasaydı Ne Olurdu?
Strategy Pattern kullanılmadığında ödeme işlemleri genellikle aşağıdaki gibi tek bir servis içerisinde yönetilir:

if (paymentType == CREDIT_CARD) {
    // Kredi kartı işlemleri
} else if (paymentType == BANK_TRANSFER) {
    // Havale işlemleri
} else if (paymentType == PAPARA) {
    // Papara işlemleri
} else if (paymentType == CRYPTO) {
    // Kripto işlemleri
}

Bu yaklaşımın bazı dezavantajları vardır:
Yeni bir ödeme yöntemi eklendiğinde mevcut servis değiştirilmek zorundadır.
Servis zamanla büyür ve yönetilmesi zorlaşır.
Test yazmak daha karmaşık hale gelir.
Kodun okunabilirliği azalır.
Open/Closed Principle ihlal edilir.
Her değişiklik mevcut çalışan kod üzerinde risk oluşturabilir.
