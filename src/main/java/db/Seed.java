package db;

import models.Shop;
import models.stock.Game;
import models.stock.GameGenre;

public class Seed {

    public static void seedData(){

//        DBHelper.deleteAll(Basket.class);
//        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Shop.class);
//        DBHelper.deleteAll(Clothing.class);
       DBHelper.deleteAll(Game.class);
//        DBHelper.deleteAll(stock.class);

        Shop shop = new Shop("Dragon Games", 1000);

        Game game1 = new Game("Grand Theft Auto V", "Grand Theft Auto V (also known as Grand Theft Auto Five, GTA 5 or GTA V) is a video game developed by Rockstar North. It is the fifteenth instalment in the Grand Theft Auto series and the successor of Grand Theft Auto IV.", 1, 25, 45, GameGenre.ACTION, "GHSR-4432", "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "https://www.youtube.com/watch?v=hvoD7ehZPcM");
        Game game2 = new Game("Metal Gear Solid", "Metal Gear Solid elaborates on the storyline of the earlier games and reveals that Solid Snake is a genetic clone of Big Boss, created as part of a secret government project. A antagonist is introduced in the form of Liquid Snake, Snake's twin brother who takes control of FOXHOUND after Snake's retirement.", 1, 20, 40, GameGenre.STRATEGY, "5432-DLAS", "https://www.cdkeys.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/m/e/metal_gear_solid_v_definitive_experience_pc_cover.jpg", "https://www.youtube.com/watch?v=_V_86OQViQE");
        Game game3 = new Game("Neverwinter Nights", "Neverwinter Nights is set in the fantasy world of the Forgotten Realms campaign setting, with the game mechanics based on the Dungeons & Dragons 3rd edition rules. The game engine was designed around an Internet-based model for running a massively multiplayer online game (MMOG)", 1, 5, 15, GameGenre.MMO, "ELIT-1337", "https://upload.wikimedia.org/wikipedia/en/7/7a/Neverwinter_Nights_cover.jpg", "https://www.youtube.com/watch?v=foZq8B2xYeg");

        DBHelper.saveOrUpdate(shop);
        DBHelper.saveOrUpdate(game1);
        DBHelper.saveOrUpdate(game2);
        DBHelper.saveOrUpdate(game3);
    }

}
