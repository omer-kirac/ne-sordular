# Ne Sordular - Frontend

Bu proje, Next.js 14 ve TypeScript kullanılarak geliştirilmiş bir topluluk platformunun frontend kısmıdır. Glassdoor benzeri bir arayüz ile kullanıcıların soru sorabildiği, iş ilanlarını görüntüleyebildiği ve şirketler hakkında bilgi alabildiği bir platformdur.

## Özellikler

- 🌓 Karanlık/Aydınlık Mod
  - Tema tercihi localStorage'da saklanır
  - Otomatik tema değişimi
  - Özelleştirilmiş renk şeması

- 📱 Modern UI/UX
  - Responsive tasarım
  - Tailwind CSS ile modern arayüz
  - Smooth geçiş animasyonları
  - Kullanıcı dostu navigasyon

- 💬 Post Sistemi
  - Anonim post paylaşma
  - Beğeni ve yorum sistemi
  - Medya desteği
  - Kategori bazlı postlar

- 👥 Kullanıcı Profili
  - Profil yönetimi
  - İş aktiviteleri
  - Katkılar
  - Ayarlar

## Teknolojiler

- Next.js 14
- TypeScript
- Tailwind CSS
- React Hooks
- Local Storage

## Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/omer-kirac/ne-sordular.git
cd my-next-app
```

2. Bağımlılıkları yükleyin:
```bash
npm install
```

3. Geliştirme sunucusunu başlatın:
```bash
npm run dev
```

4. Tarayıcınızda açın:
```
http://localhost:3000
```

## Proje Yapısı

```
src/
├── app/
│   ├── layout.tsx    # Ana layout bileşeni
│   ├── page.tsx      # Ana sayfa
│   ├── sorular/      # Sorular sayfası
│   ├── is-ilanlari/  # İş ilanları sayfası
│   ├── sirketler/    # Şirketler sayfası
│   └── maaslar/      # Maaşlar sayfası
└── components/       # Paylaşılan bileşenler
```

## Özellik Detayları

### Tema Sistemi
- Aydınlık/Karanlık mod desteği
- Yeşil tonlarında modern tasarım
- Göz yorgunluğunu azaltan renk paleti
- Responsive ve tutarlı UI

### Navigasyon
- Aktif sayfa göstergesi
- Smooth geçiş efektleri
- Dropdown menüler
- Mobil uyumlu tasarım

### Post Sistemi
- Zengin metin editörü
- Medya yükleme desteği
- Etkileşim butonları
- Dinamik içerik yükleme

## Katkıda Bulunma

1. Bu projeyi fork edin
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'feat: Add some amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır.
