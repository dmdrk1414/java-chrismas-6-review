package christmas.domain.freebie;

import christmas.config.Config;
import christmas.constant.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private final Champagne champagne;

    public Freebie() {
        this.champagne = Config.champagne();
    }

    public Boolean isEligibleChampagne(Integer totalOrderMoney) {
        return isEligible(totalOrderMoney);
    }

    public Map<String, Integer> getPriceInformations(Integer totalOrderMoney) {
        Map<String, Integer> informations = new HashMap<>();
        Map<String, Integer> champagnePriceInformation = champagne.makeChampagnePriceInformation();

        if (isEligible(totalOrderMoney)) {
            informations.putAll(champagnePriceInformation);
        }

        return informations;
    }

    public Integer getFreebiePrice(Integer totalOrderMoney) {
        Integer freebiePrice = 0;

        if (isEligible(totalOrderMoney)) {
            freebiePrice = Menu.CHAMPAGNE.getPrice();
        }

        return freebiePrice;
    }

    public Map<String, Integer> getFreebieCount(Integer totalOrderMoney) {
        Map<String, Integer> freebies = new HashMap<>();
        Map<String, Integer> champagneCountInformation = champagne.makeChampagneCountInformation();

        if (isEligible(totalOrderMoney)) {
            freebies.putAll(champagneCountInformation);
        }

        return freebies;
    }

    private Boolean isEligible(Integer totalOrderMoney) {
        return champagne.isEligible(totalOrderMoney);
    }
}
