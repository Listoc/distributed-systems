package etu.lab3.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class DrugData {
    private static final Pattern DOSAGE_PATTERN = Pattern.compile("^.* (\\d+ (мг|мкг|мл|г)).*$");
    private String tradename;
    private String dosageform;
    private String limitingprice;
    private String info;

    @Override
    public int hashCode() {
        return Objects.hash(tradename, dosageform, limitingprice);
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = deleteStars(tradename);
    }

    public String getDosageform() {
        return dosageform;
    }

    public String getInfo() {
        return info;
    }

    public void setDosageform(String dosageform) {
        this.info = dosageform;
        var matcher = DOSAGE_PATTERN.matcher(dosageform);

        if (matcher.matches()) {
            this.dosageform = matcher.group(1);
        } else {
            this.dosageform = "";
        }
    }

    public String getLimitingprice() {
        return limitingprice;
    }

    public void setLimitingprice(String limitingprice) {
        this.limitingprice = limitingprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugData drugData = (DrugData) o;
        return Objects.equals(tradename, drugData.tradename) && Objects.equals(dosageform, drugData.dosageform) && Objects.equals(limitingprice, drugData.limitingprice);
    }

    @Override
    public String toString() {
        return "DrugData{" +
                "tradename='" + tradename + '\'' +
                ", dosageform='" + dosageform + '\'' +
                ", limitingprice='" + limitingprice + '\'' +
                '}';
    }

    private String deleteStars(String string) {
        var builder = new StringBuilder();

        for (var ch : string.toCharArray()) {
            if (ch == '*' || ch == '(' || ch == ')') {
                continue;
            }

            builder.append(ch);
        }

        return builder.toString();
    }
}
