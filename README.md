# Ne Sordular

Bu proje, kullanıcıların anonim olarak post paylaşabildiği, yorum yapabildiği ve beğeni verebildiği bir platformdur.

## Özellikler

- Anonim post paylaşma
- İsteğe bağlı yazar ismi ekleme
- Post beğenme
- Yorum yapma
- Anonim yorum yapma

## Teknolojiler

- Java 17
- Spring Boot 3.4.1
- MySQL 8
- Spring Data JPA
- Spring Security
- Lombok

## Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/omer-kirac/ne-sordular-.git
```

2. MySQL veritabanını oluşturun:
```sql
CREATE DATABASE ne_sordular;
```

3. `.env` dosyası oluşturun ve gerekli değişkenleri ayarlayın:
```
MYSQL_URL=jdbc:mysql://localhost:3306/ne_sordular?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
MYSQL_USER=your_username
MYSQL_PASSWORD=your_password
```

4. Projeyi çalıştırın:
```bash
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

### Comments
- `POST /api/comments` - Yeni yorum oluşturma
- `GET /api/comments` - Tüm yorumları listeleme
- `GET /api/comments/{id}` - Tek bir yorum getirme
- `PUT /api/comments/{id}` - Yorum güncelleme
- `DELETE /api/comments/{id}` - Yorum silme

## Örnek İstekler

### Post Oluşturma
```json
{
    "content": "Bu bir test postudur",
    "authorName": "John Doe",  // İsteğe bağlı
    "isAnonymous": false,
    "user": {
        "id": 1
    }
}
```

### Yorum Oluşturma
```json
{
    "content": "Harika bir post!",
    "authorName": "Jane Doe",  // İsteğe bağlı
    "isAnonymous": true,
    "post": {
        "id": 1
    },
    "user": {
        "id": 1
    }
}
``` 