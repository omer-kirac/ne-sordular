# Ne Sordular

Bu proje, kullanıcıların anonim olarak post paylaşabildiği, şirketler hakkında değerlendirme yapabildiği, mülakat deneyimlerini paylaşabildiği ve maaş bilgilerini paylaşabildiği bir platformdur.

## Proje Yapısı

- `/backend` - Spring Boot backend uygulaması
- `/frontend` - Frontend uygulaması (Yakında eklenecek)

## Özellikler

### Post Sistemi
- Anonim post paylaşma
- İsteğe bağlı yazar ismi ekleme
- Post beğenme
- Yorum yapma
- Medya ekleme desteği
- Anonim yorum yapma

### Şirket Değerlendirme Sistemi
- Şirket puanlama (5 üzerinden)
  - Kariyer Fırsatları
  - Yan haklar
  - Kültür ve değerler
  - Çeşitlilik ve Katılım
  - Üst Yönetim
  - İş/Yaşam dengesi
- Detaylı şirket değerlendirmeleri
  - Çalışan durumu (Mevcut/Eski çalışan)
  - Olumlu yönler
  - Olumsuz yönler
  - Yönetime tavsiyeler

### Maaş Bilgileri
- Ana ücret (Aylık/Yıllık)
- Para birimi seçeneği
- Ek ödemeler
  - Bonus
  - Hisse senedi
  - Kar paylaşımı
  - Komisyon
  - Bahşiş

### Mülakat Deneyimleri
- Mülakat süreci açıklaması
- Zorluk derecesi (5 üzerinden)
- Teklif durumu (Evet/Hayır/Süreç devam ediyor)
- Mülakat soruları
- Başvuru yöntemi
- Süreç süresi
- Mülakat tarihi
- Mülakat stilleri (Yüzyüze/Test/Teknik Test)

## Backend Teknolojileri

- Java 17
- Spring Boot 3.4.1
- MySQL 8
- Spring Data JPA
- Spring Security
- Lombok

## Backend Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/omer-kirac/ne-sordular.git
```

2. MySQL veritabanını oluşturun:
```sql
CREATE DATABASE ne_sordular;
```

3. `backend/.env` dosyası oluşturun ve gerekli değişkenleri ayarlayın:
```
MYSQL_URL=jdbc:mysql://localhost:3306/ne_sordular?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
MYSQL_USER=your_username
MYSQL_PASSWORD=your_password
```

4. Backend projesini çalıştırın:
```bash
cd backend
./mvnw spring-boot:run
```

## API Endpoints

### Posts
- `POST /api/posts` - Yeni post oluşturma
- `GET /api/posts` - Tüm postları listeleme
- `GET /api/posts/{id}` - Tek bir post getirme
- `PUT /api/posts/{id}` - Post güncelleme
- `DELETE /api/posts/{id}` - Post silme
- `POST /api/posts/{id}/like` - Post beğenme

### Companies
- `POST /api/companies` - Yeni şirket oluşturma
- `GET /api/companies` - Tüm şirketleri listeleme
- `GET /api/companies/{id}` - Tek bir şirket getirme
- `GET /api/companies/{id}/reviews` - Şirket değerlendirmelerini getirme
- `GET /api/companies/{id}/salaries` - Şirket maaş bilgilerini getirme
- `GET /api/companies/{id}/interviews` - Şirket mülakat deneyimlerini getirme

### Reviews
- `POST /api/reviews` - Yeni değerlendirme oluşturma
- `GET /api/reviews` - Tüm değerlendirmeleri listeleme
- `GET /api/reviews/{id}` - Tek bir değerlendirme getirme

### Salaries
- `POST /api/salaries` - Yeni maaş bilgisi oluşturma
- `GET /api/salaries` - Tüm maaş bilgilerini listeleme
- `GET /api/salaries/{id}` - Tek bir maaş bilgisi getirme

### Interviews
- `POST /api/interviews` - Yeni mülakat deneyimi oluşturma
- `GET /api/interviews` - Tüm mülakat deneyimlerini listeleme
- `GET /api/interviews/{id}` - Tek bir mülakat deneyimi getirme

## Örnek İstekler

### Post Oluşturma
```json
{
    "content": "Bu bir test postudur",
    "authorName": "John Doe",  // İsteğe bağlı
    "isAnonymous": false,
    "mediaUrls": ["https://example.com/image1.jpg"],
    "user": {
        "id": 1
    }
}
```

### Şirket Değerlendirmesi Oluşturma
```json
{
    "employeeStatus": "CURRENT_EMPLOYEE",
    "headline": "Harika bir çalışma ortamı",
    "pros": "Esnek çalışma saatleri, iyi yan haklar",
    "cons": "Kariyer gelişimi yavaş",
    "adviceToManagement": "Daha fazla eğitim fırsatı sunulabilir",
    "rating": {
        "careerOpportunities": 4,
        "benefits": 5,
        "cultureAndValues": 4,
        "diversityAndInclusion": 5,
        "seniorManagement": 4,
        "workLifeBalance": 5
    },
    "company": {
        "id": 1
    },
    "user": {
        "id": 1
    }
}
```

### Maaş Bilgisi Oluşturma
```json
{
    "baseSalary": 10000,
    "paymentPeriod": "MONTHLY",
    "currency": "TRY",
    "bonus": 20000,
    "stocks": 5000,
    "profitSharing": 10000,
    "commission": null,
    "tips": null,
    "company": {
        "id": 1
    },
    "user": {
        "id": 1
    }
}
```

### Mülakat Deneyimi Oluşturma
```json
{
    "processDescription": "3 aşamalı mülakat süreci",
    "difficultyRating": 4,
    "offerStatus": "YES",
    "questions": [
        "Algoritma sorusu: İki sayının OBEB'ini bulun",
        "Spring Boot nedir?",
        "Microservice mimarisi hakkında ne düşünüyorsunuz?"
    ],
    "applicationMethod": "LinkedIn üzerinden",
    "processDuration": "2 hafta",
    "interviewDate": "2024-01-15",
    "interviewStyles": ["FACE_TO_FACE", "TECHNICAL_TEST"],
    "company": {
        "id": 1
    },
    "user": {
        "id": 1
    }
}
``` 