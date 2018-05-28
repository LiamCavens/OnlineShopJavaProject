package db;

import models.stock.Clothing;
import models.stock.Console;
import models.stock.Game;

public class Seed {

    public static void seedData(){

//        DBHelper.deleteAll(Basket.class);
//        DBHelper.deleteAll(Customer.class);
       DBHelper.deleteAll(Clothing.class);
       DBHelper.deleteAll(Game.class);
//        DBHelper.deleteAll(stock.class);


        Console console1 = new Console("Xbox One", "The world's most powerful console" , 20, 300.00, 450.00, "https://i1.wp.com/freepngimages.com/wp-content/uploads/2015/10/playstation-4-games-console.png?fit=624%2C365");

        Game game1 = new Game("Grand Theft Auto V", "Grand Theft Auto V (also known as Grand Theft Auto Five, GTA 5 or GTA V) is a video game developed by Rockstar North. It is the fifteenth instalment in the Grand Theft Auto series and the successor of Grand Theft Auto IV.", 1, 25, 45, "Action", "GHSR-4432", "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
        Game game2 = new Game("Metal Gear Solid", "Metal Gear Solid elaborates on the storyline of the earlier games and reveals that Solid Snake is a genetic clone of Big Boss, created as part of a secret government project.", 1, 20, 40, "Strategy", "5432-DLAS", "https://www.cdkeys.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/m/e/metal_gear_solid_v_definitive_experience_pc_cover.jpg", "https://www.youtube.com/watch?v=_V_86OQViQE");
        Game game3 = new Game("Neverwinter Nights", "Neverwinter Nights is set in the fantasy world of the Forgotten Realms campaign setting, with the game mechanics based on the Dungeons & Dragons 3rd edition rules.", 1, 5, 15, "MMO", "ELIT-1337", "https://upload.wikimedia.org/wikipedia/en/7/7a/Neverwinter_Nights_cover.jpg", "https://www.youtube.com/watch?v=foZq8B2xYeg");

        Clothing clothing1 = new Clothing("I Went Outside Once The Graphics Weren't Great T-Shirt", "Looking for the perfect excuse for staying inside a lot? This tee features a disheartened looking chap looking out onto a pixelated field and sky, while the caption 'I went outside once. The graphics weren't great.' is featured alongside. Well, some things in life are just a bit disappointing.", 1, 10, 20, "https://d1x7zurbps6occ.cloudfront.net/product/xlarge/513175-150221.jpg");
        Clothing clothing2 = new Clothing("Fallout T-Shirt", "Do you dare try and escape the vault? Set in a terrifying apocalyptic world, this eerie Fallout 4 t-shirt displays the Vault Boy mascot, pictured alongside the warnings of 'Surface - Never! Vault - Forever!' Official merchandise.", 1, 10, 40, "https://d1x7zurbps6occ.cloudfront.net/product/xlarge/529473-153868.jpg");
        Clothing clothing3 = new Clothing("Doom T-Shirt", "BFG not included", 1, 10, 60, "https://images-na.ssl-images-amazon.com/images/I/41Ab4IQzDqL.jpg");
        Clothing clothing4 = new Clothing("Leather Kilt", "Pants needed", 1, 5, 10, "http://www.leatherexotica.com/wp-content/uploads/2015/06/LEMK-012.jpg");

        DBHelper.saveOrUpdate(game1);
        DBHelper.saveOrUpdate(game2);
        DBHelper.saveOrUpdate(game3);
        DBHelper.saveOrUpdate(clothing1);
        DBHelper.saveOrUpdate(clothing2);
        DBHelper.saveOrUpdate(clothing3);
        DBHelper.saveOrUpdate(clothing4);
    }

}
