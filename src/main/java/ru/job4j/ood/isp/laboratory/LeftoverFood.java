package ru.job4j.ood.isp.laboratory;

public class LeftoverFood implements Action {

    @Override
    public void action(Laboratory laboratory) {
        System.out.println("Актуальное количество еды: " + laboratory.getFood());
    }

    @Override
    public String getName() {
        return "Показать количество оставшейся еды";
    }
}
