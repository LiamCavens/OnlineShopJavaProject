package db;

import models.Basket;
import models.stock.Clothing;
import models.stock.Console;
import models.stock.Game;

public class Seed {

    public static void seedData(){

        DBHelper.deleteAll(Basket.class);
//        DBHelper.deleteAll(Customer.class);
       DBHelper.deleteAll(Clothing.class);
       DBHelper.deleteAll(Game.class);
//        DBHelper.deleteAll(stock.class);


        Basket defaultBasket = new Basket();

        Game game1 = new Game("Grand Theft Auto V", "Grand Theft Auto V (also known as Grand Theft Auto Five, GTA 5 or GTA V) is a video game developed by Rockstar North. It is the fifteenth instalment in the Grand Theft Auto series and the successor of Grand Theft Auto IV.", 1, 25, 45, "Action", "GHSR-4432", "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/hvoD7ehZPcM?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
        Game game2 = new Game("Metal Gear Solid", "Metal Gear Solid elaborates on the storyline of the earlier games and reveals that Solid Snake is a genetic clone of Big Boss, created as part of a secret government project.", 1, 20, 40, "Strategy", "5432-DLAS", "https://www.cdkeys.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/m/e/metal_gear_solid_v_definitive_experience_pc_cover.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_V_86OQViQE?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
        Game game3 = new Game("Neverwinter Nights", "Neverwinter Nights is set in the fantasy world of the Forgotten Realms campaign setting, with the game mechanics based on the Dungeons & Dragons 3rd edition rules.", 1, 5, 15, "RPG", "ELIT-1337", "https://upload.wikimedia.org/wikipedia/en/7/7a/Neverwinter_Nights_cover.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/o6wyNadJLsg?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");

        Console console1 = new Console("Xbox One", "The world's most powerful console" , 20, 320.00, 420.00, "http://www.techdaring.com/wp-content/uploads/2016/01/xbox-one-slim.png");
        Console console2 = new Console("Playstation 4", "For the players" , 20, 300.00, 400.00, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/PS4-Console-wDS4.png/1200px-PS4-Console-wDS4.png");

        Clothing clothing1 = new Clothing("I Went Outside Once The Graphics Weren't Great T-Shirt", "Looking for the perfect excuse for staying inside a lot?", 1, 10, 20, "https://d1x7zurbps6occ.cloudfront.net/product/xlarge/513175-150221.jpg");
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

        DBHelper.saveOrUpdate(console1);
        DBHelper.saveOrUpdate(console2);

    }

}
