package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Data
@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create Categories

        /*Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        Category books = new Category();
        books.setName("Books"); // ✅ richtige Verwendung von 'books'

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing, books));

        // Create Products

        // --- Electronics ---
        Product phone = new Product();
        phone.setName("Samsung Galaxy S23");
        phone.setDescription("High-end smartphone with AMOLED display and triple camera.");
        phone.setImageUrl("https://images.samsung.com/is/image/samsung/p6pim/de/galaxys23/gallery/de-galaxy-s23-s911-sm-s911bzadeub-thumb-535935646?$650_519_PNG$");
        phone.setPrice(849.99);
        phone.setCategory(electronics);

        Product macbook = new Product();
        macbook.setName("MacBook Air M2");
        macbook.setDescription("Ultra-thin notebook with M2 chip and retina display.");
        macbook.setImageUrl("https://store.storeimages.cdn-apple.com/.../macbook-air.jpg");
        macbook.setPrice(1299.00);
        macbook.setCategory(electronics);

        Product headphones = new Product();
        headphones.setName("Sony WH-1000XM5");
        headphones.setDescription("Wireless noise-canceling headphones with premium sound.");
        headphones.setImageUrl("https://m.media-amazon.com/images/I/61bM3+vUanL._AC_SL1500_.jpg");
        headphones.setPrice(379.00);
        headphones.setCategory(electronics);

        Product watch = new Product();
        watch.setName("Apple Watch Series 9");
        watch.setDescription("Smartwatch with health tracking and always-on display.");
        watch.setImageUrl("https://store.storeimages.cdn-apple.com/.../apple-watch.jpg");
        watch.setPrice(499.00);
        watch.setCategory(electronics);

        // --- Clothing ---
        Product tshirt = new Product();
        tshirt.setName("Basic Cotton T-Shirt");
        tshirt.setDescription("Unisex T-Shirt made from 100% organic cotton.");
        tshirt.setImageUrl("https://placehold.co/600x400?text=T-Shirt");
        tshirt.setPrice(19.99);
        tshirt.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Slim Fit Jeans");
        jeans.setDescription("Comfortable jeans with modern slim fit design.");
        jeans.setImageUrl("https://placehold.co/600x400?text=Jeans");
        jeans.setPrice(49.99);
        jeans.setCategory(clothing);

        Product sneakers = new Product();
        sneakers.setName("Nike Air Max");
        sneakers.setDescription("Popular sneakers with great cushioning and comfort.");
        sneakers.setImageUrl("https://m.media-amazon.com/images/I/71jYwQpI2tL._AC_UL1500_.jpg");
        sneakers.setPrice(129.00);
        sneakers.setCategory(clothing);

        Product parka = new Product();
        parka.setName("Winter Parka");
        parka.setDescription("Warm and waterproof parka with synthetic insulation.");
        parka.setImageUrl("https://placehold.co/600x400?text=Jacket");
        parka.setPrice(89.90);
        parka.setCategory(clothing);

        // --- Books ---
        Product novel = new Product();
        novel.setName("The Midnight Library");
        novel.setDescription("A thought-provoking novel about parallel lives by Matt Haig.");
        novel.setImageUrl("https://m.media-amazon.com/images/I/81F-qjK4cuL._SL1500_.jpg");
        novel.setPrice(14.99);
        novel.setCategory(books);

        Product cleanCode = new Product();
        cleanCode.setName("Clean Code");
        cleanCode.setDescription("A handbook of agile software craftsmanship by Robert C. Martin.");
        cleanCode.setImageUrl("https://m.media-amazon.com/images/I/41xShlnTZTL._SX374_BO1,204,203,200_.jpg");
        cleanCode.setPrice(39.99);
        cleanCode.setCategory(books);

        Product cookbook = new Product();
        cookbook.setName("Jamie's 5 Ingredients");
        cookbook.setDescription("Quick & easy food recipes using only five ingredients.");
        cookbook.setImageUrl("https://m.media-amazon.com/images/I/81BgOD9TXzL._AC_SL1500_.jpg");
        cookbook.setPrice(24.90);
        cookbook.setCategory(books);

        Product biography = new Product();
        biography.setName("Becoming – Michelle Obama");
        biography.setDescription("An intimate and inspiring memoir by the former First Lady.");
        biography.setImageUrl("https://m.media-amazon.com/images/I/81h2gWPTYJL._AC_SL1500_.jpg");
        biography.setPrice(21.50);
        biography.setCategory(books);

        // --- Home ---
        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies and more.");
        blender.setImageUrl("https://placehold.co/600x400?text=Blender");
        blender.setPrice(89.99);
        blender.setCategory(home);

        Product toaster = new Product();
        toaster.setName("2-Slice Toaster");
        toaster.setDescription("مرحبا كيف حالك");
        toaster.setImageUrl("https://placehold.co/600x400?text=Toaster");
        toaster.setPrice(39.99);
        toaster.setCategory(home);

        Product vacuum = new Product();
        vacuum.setName("Robotic Vacuum Cleaner");
        vacuum.setDescription("Automatically cleans floors, smart navigation.");
        vacuum.setImageUrl("https://placehold.co/600x400?text=Vacuum");
        vacuum.setPrice(229.00);
        vacuum.setCategory(home);

        Product kettle = new Product();
        kettle.setName("Electric Kettle");
        kettle.setDescription("Fast-boil electric kettle with 1.7L capacity.");
        kettle.setImageUrl("https://placehold.co/600x400?text=Kettle");
        kettle.setPrice(29.90);
        kettle.setCategory(home);

        // Save all products
        productRepository.saveAll(Arrays.asList(
                phone, macbook, headphones, watch,
                tshirt, jeans, sneakers, parka,
                novel, cleanCode, cookbook, biography,
                blender, toaster, vacuum, kettle
        ));

         */

        Category women = new Category();
        women.setName("نساء");

        Category men = new Category();
        men.setName("رجال");

        Category kids = new Category();
        kids.setName("أطفال");

        categoryRepository.saveAll(Arrays.asList(women, men, kids));


        // Damen//
        Product dress = new Product();
        dress.setName("فستان سهرة أنيق");
        dress.setDescription("فستان طويل بتصميم فاخر مثالي للمناسبات الخاصة.");
        dress.setImageUrl("https://m.media-amazon.com/images/I/71rHWi+IpPL._AC_UL1500_.jpg");
        dress.setPrice(129.99);
        dress.setCategory(women);

        Product abaya = new Product();
        abaya.setName("عباية مطرزة");
        abaya.setDescription("عباية سوداء بتطريز ذهبي ناعم.");
        abaya.setImageUrl("https://m.media-amazon.com/images/I/61OZQ5LMeBL._AC_UL1500_.jpg");
        abaya.setPrice(99.99);
        abaya.setCategory(women);

        Product blouse = new Product();
        blouse.setName("بلوزة قطنية");
        blouse.setDescription("بلوزة خفيفة بأكمام طويلة مصنوعة من القطن.");
        blouse.setImageUrl("https://m.media-amazon.com/images/I/71uTVlEYNwL._AC_UL1500_.jpg");
        blouse.setPrice(39.99);
        blouse.setCategory(women);

        Product skirt = new Product();
        skirt.setName("تنورة طويلة");
        skirt.setDescription("تنورة نسائية مريحة بطبقات من الشيفون.");
        skirt.setImageUrl("https://m.media-amazon.com/images/I/61KekPRhK3L._AC_UL1500_.jpg");
        skirt.setPrice(49.90);
        skirt.setCategory(women);

        Product jeansWomen = new Product();
        jeansWomen.setName("بنطال جينز نسائي");
        jeansWomen.setDescription("بنطال جينز بخصر عالٍ ومظهر عصري.");
        jeansWomen.setImageUrl("https://m.media-amazon.com/images/I/61KdpMfStsL._AC_UL1500_.jpg");
        jeansWomen.setPrice(59.99);
        jeansWomen.setCategory(women);

        Product shoesWomen = new Product();
        shoesWomen.setName("حذاء كعب عالي");
        shoesWomen.setDescription("حذاء أنيق بكعب عالي مثالي للحفلات.");
        shoesWomen.setImageUrl("https://m.media-amazon.com/images/I/61u3vf7DxIL._AC_UL1500_.jpg");
        shoesWomen.setPrice(89.00);
        shoesWomen.setCategory(women);


        //Herrn//

        Product shirtMen = new Product();
        shirtMen.setName("قميص رسمي");
        shirtMen.setDescription("قميص رجالي بأكمام طويلة مناسب للعمل.");
        shirtMen.setImageUrl("https://m.media-amazon.com/images/I/61S4VhZVWDL._AC_UL1500_.jpg");
        shirtMen.setPrice(45.99);
        shirtMen.setCategory(men);

        Product jeansMen = new Product();
        jeansMen.setName("بنطال جينز رجالي");
        jeansMen.setDescription("بنطال جينز بتصميم عصري وراحة مثالية.");
        jeansMen.setImageUrl("https://m.media-amazon.com/images/I/71YXRfnrFlL._AC_UL1500_.jpg");
        jeansMen.setPrice(54.90);
        jeansMen.setCategory(men);

        Product tshirtMen = new Product();
        tshirtMen.setName("تيشيرت قطن");
        tshirtMen.setDescription("تيشيرت رجالي خفيف مصنوع من قطن عضوي.");
        tshirtMen.setImageUrl("https://m.media-amazon.com/images/I/61ccz0n2LFL._AC_UL1500_.jpg");
        tshirtMen.setPrice(22.50);
        tshirtMen.setCategory(men);

        Product jacketMen = new Product();
        jacketMen.setName("جاكيت شتوي");
        jacketMen.setDescription("جاكيت رجالي دافئ مقاوم للرياح.");
        jacketMen.setImageUrl("https://m.media-amazon.com/images/I/61cp4tVzPFL._AC_UL1500_.jpg");
        jacketMen.setPrice(109.99);
        jacketMen.setCategory(men);

        Product shoesMen = new Product();
        shoesMen.setName("حذاء رياضي");
        shoesMen.setDescription("حذاء مريح للرياضة والمشي اليومي.");
        shoesMen.setImageUrl("https://m.media-amazon.com/images/I/71jYwQpI2tL._AC_UL1500_.jpg");
        shoesMen.setPrice(79.00);
        shoesMen.setCategory(men);

        Product suit = new Product();
        suit.setName("بدلة رسمية");
        suit.setDescription("بدلة أنيقة مثالية للمناسبات الرسمية.");
        suit.setImageUrl("https://m.media-amazon.com/images/I/71w6X5xsfhL._AC_UL1500_.jpg");
        suit.setPrice(199.99);
        suit.setCategory(men);


        //Kids//

        Product tshirtKid = new Product();
        tshirtKid.setName("تيشيرت أطفال");
        tshirtKid.setDescription("تيشيرت قطني للأطفال برسومات مرحة.");
        tshirtKid.setImageUrl("https://m.media-amazon.com/images/I/61I38rf6znL._AC_SX679_.jpg");
        tshirtKid.setPrice(14.99);
        tshirtKid.setCategory(kids);

        Product dressKid = new Product();
        dressKid.setName("فستان بناتي");
        dressKid.setDescription("فستان ناعم مناسب للمناسبات والحفلات.");
        dressKid.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHKJRIRO-4b7r-v-o7flcisZtaARF6bXTvOQ&s");
        dressKid.setPrice(34.99);
        dressKid.setCategory(kids);

        Product jeansKid = new Product();
        jeansKid.setName("بنطال جينز أطفال");
        jeansKid.setDescription("بنطال جينز عملي ومتين للأطفال.");
        jeansKid.setImageUrl("https://www.okaidi.ma/3629634-large_default/boy-s-blue-heavy-duty-straight-leg-jeans.webp");
        jeansKid.setPrice(24.90);
        jeansKid.setCategory(kids);

        Product jacketKid = new Product();
        jacketKid.setName("جاكيت أطفال شتوي");
        jacketKid.setDescription("جاكيت دافئ مقاوم للمطر للأطفال.");
        jacketKid.setImageUrl("https://image.made-in-china.com/202f0j00GvmhRnJZkVUc/Girls-Waterproof-Warm-Windproof-Snow-Winter-Coat-Ski-Jacket.webp");
        jacketKid.setPrice(44.99);
        jacketKid.setCategory(kids);

        Product shoesKid = new Product();
        shoesKid.setName("حذاء رياضي أطفال");
        shoesKid.setDescription("حذاء رياضي مريح للأطفال للتنقل اليومي.");
        shoesKid.setImageUrl("https://cdn.salla.sa/Oqrvoe/8a27a734-0434-4e18-809a-797b8cf4be68-1000x1000-pMCeQw74HRHk1FAQ20ZAy4WpKt8lbrOBV7cMOm2e.jpg");
        shoesKid.setPrice(29.99);
        shoesKid.setCategory(kids);

        Product hoodieKid = new Product();
        hoodieKid.setName("هودي أطفال");
        hoodieKid.setDescription("هودي مريح وناعم مثالي للأيام الباردة.");
        hoodieKid.setImageUrl("https://m.media-amazon.com/images/I/61gedha1hpL._AC_SY606_.jpg");
        hoodieKid.setPrice(27.50);
        hoodieKid.setCategory(kids);


        productRepository.saveAll(Arrays.asList(
                dress, abaya, blouse, skirt, jeansWomen, shoesWomen,
                shirtMen, jeansMen, tshirtMen, jacketMen, shoesMen, suit,
                tshirtKid, dressKid, jeansKid, jacketKid, shoesKid, hoodieKid
        ));





    }

}
