
package pv260.solid.dip.tweaked;


public class Main {

    public static void main(String[] args) throws Exception {
        RecommendationService outfitService = new RecomendedOutfitService();
        RecommendationService lunchService = new RecommendedLunchService();
        System.out.println("o--         Awesome Lifestyle Page               --o");
        System.out.println("Tomorrow, it would be wise to dress like this:");
        System.out.println(outfitService.recommendForTomorrow());
        System.out.println("For luch, we recomend that you:");
        System.out.println(lunchService.recommendForTomorrow());
        System.out.println("o--                                              --o");
    }

}
