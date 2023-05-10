import javax.swing.JComboBox;

public class Dropdown {
    JComboBox<String> fromComboBox, toComboBox;
    String[] currencies;

    Dropdown() {
        String[] currenciesDummy = { "USD", "INR", "MXN", "SCR", "TVD", "CDF", "BBD", "GTQ", "CLP",
                "HNL", "UGX", "ZAR", "TND", "STN", "SLE", "JOD", "AED", "TMT", "BRL",
                "HKD", "RWF", "EUR", "FOK", "LSL", "DKK", "CAD", "KID", "BGN", "MMK",
                "MUR", "NOK", "SYP", "IMP", "ZWL", "GIP", "RON", "LKR", "NGN", "CRC",
                "CZK", "PKR", "XCD", "ANG", "HTG", "BHD", "KZT", "SRD", "SZL", "SAR",
                "TTD", "YER", "MVR", "AFN", "FJD", "AWG", "KRW", "NPR", "JPY", "MNT",
                "AOA", "PLN", "GBP", "SBD", "BYN", "HUF", "BIF", "MWK", "MGA", "XDR",
                "BZD", "BAM", "EGP", "MOP", "NAD", "SSP", "NIO", "PEN", "NZD", "WST"
        };
        currencies = currenciesDummy;

        fromComboBox = new JComboBox<>(currencies);
        toComboBox = new JComboBox<>(currencies);
        fromComboBox.setBounds(60, 60, 100, 50);
        toComboBox.setBounds(240, 60, 100, 50);
        fromComboBox.setSelectedItem(currencies[0]);
        toComboBox.setSelectedItem(currencies[0]);
    }
}
