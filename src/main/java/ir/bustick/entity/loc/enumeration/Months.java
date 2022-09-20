package ir.bustick.entity.loc.enumeration;

public enum Months {
    NULL(null),
    FARVARDIN("فروردین"),
    ORDIBEHESHT("اردیبهشت"),
    KHORDAD("خرداد"),
    TIR("تیر"),
    MORDAD("مرداد"),
    SHAHRIVAR("شهریور"),
    MEHR("مهر"),
    ABAN("آبان"),
    AZAR("آذر"),
    DEY("دی"),
    BAHMAN("بهمن"),
    ESFAND("اسفند");

    public final String farsiMonth;

    private Months(String farsiMonth){
        this.farsiMonth = farsiMonth;
    }
}
