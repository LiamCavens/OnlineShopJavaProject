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



        Game game1 = new Game("Grand Theft Auto V", "Grand Theft Auto V (also known as Grand Theft Auto Five, GTA 5 or GTA V) is a video game developed by Rockstar North. It is the fifteenth instalment in the Grand Theft Auto series and the successor of Grand Theft Auto IV.", 1, 25, 45, "Action", "GHSR-4432", "https://static-cdn.jtvnw.net/ttv-boxart/Grand%20Theft%20Auto%20V.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/hvoD7ehZPcM\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
        Game game2 = new Game("Metal Gear Solid", "Metal Gear Solid elaborates on the storyline of the earlier games and reveals that Solid Snake is a genetic clone of Big Boss, created as part of a secret government project.", 1, 20, 40, "Strategy", "5432-DLAS", "https://www.cdkeys.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/m/e/metal_gear_solid_v_definitive_experience_pc_cover.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/_V_86OQViQE\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
        Game game3 = new Game("Neverwinter Nights", "Neverwinter Nights is set in the fantasy world of the Forgotten Realms campaign setting, with the game mechanics based on the Dungeons & Dragons 3rd edition rules.", 1, 5, 15, "MMO", "ELIT-1337", "https://upload.wikimedia.org/wikipedia/en/7/7a/Neverwinter_Nights_cover.jpg", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/-5A_-hxtSqs\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");

        Console console1 = new Console("Xbox One", "The world's most powerful console" , 20, 300.00, 450.00, "https://i1.wp.com/freepngimages.com/wp-content/uploads/2015/10/playstation-4-games-console.png?fit=624%2C365");


        DBHelper.saveOrUpdate(game1);
        DBHelper.saveOrUpdate(game2);
        DBHelper.saveOrUpdate(game3);
        DBHelper.saveOrUpdate(console1);
    }

}
