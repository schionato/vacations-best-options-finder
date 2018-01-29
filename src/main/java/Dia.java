import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Dia {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate raw;

    protected Dia(LocalDate raw) {
        this.raw = raw;
    }

    Dia(String data) {
        this.raw = LocalDate.parse(data, FORMATTER);
    }

    boolean ehUmDiaUtil() {
        int diaDaSemana = this.raw.getDayOfWeek().getValue();
        return diaDaSemana != DayOfWeek.SUNDAY.getValue() && diaDaSemana != DayOfWeek.SATURDAY.getValue();
    }

    boolean antes(Dia outroDia) {
        return raw.isBefore(outroDia.raw);
    }

    boolean igual(Dia outroDia) {
        return raw.isEqual(outroDia.raw);
    }

    Amanha getAmanha() {
        return new Amanha(raw.plusDays(1L));
    }
}
