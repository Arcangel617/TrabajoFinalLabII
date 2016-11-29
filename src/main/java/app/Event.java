package app;

/**
 * Created by arcangel on 23/11/16.
 */
public class Event {
    private long id;
    private String name;
    private Calendar owner;
    private String horaInicio;
    private String horaFin;
    private String fechaInicio;
    private String fechaFin;

    public Event(){}

    public Event(String name){
        this.name = name;
    }

    public Event(long eventId, String name, String fechaInicio, String fechaFin,
                 String horaInicio, String horaFin, long calendarId) {
        this.id = eventId;
        this.name = name;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.owner = CalendarSource.getCalendar(calendarId);
    }

    public Event(long id, String name, int diaInicio, int mesInicio, int anioInicio,
                 int diaFin, int mesFin, int anioFin,
                 int hinicio, int minicio, int sinicio,
                 int hfin, int mfin, int sfin, long calendarId) {
        this.id = id;
        this.name = name;
        this.fechaInicio = formatearFecha(diaInicio,mesInicio,anioInicio);
        this.fechaFin = formatearFecha(diaFin,mesFin,anioFin);
        this.horaInicio = formatearHora(hinicio, minicio, sinicio);
        this.horaFin = formatearHora(hfin, mfin, sfin);
        this.owner = CalendarSource.getCalendar(calendarId);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getOwner(){
        return owner;
    }

    public String getFechaInicio(){
        return fechaInicio;
    }

    public String getFechaFin(){
        return fechaFin;
    }

    public String getHoraInicio(){
        return horaInicio;
    }

    public String getHoraFin(){
        return horaFin;
    }

    private String formatearHora(int hora, int min, int seg){
        StringBuilder sb = new StringBuilder();
        if (hora < 10){
            sb.append("0"+hora);
        } else {
            sb.append(hora);
        }
        if (min < 10){
            sb.append(":0"+min);
        } else {
            sb.append(":"+min);
        }
        if (seg < 10){
            sb.append(":0"+seg);
        } else {
            sb.append(":"+seg);
        }
        return sb.toString();

    }

    private String formatearFecha(int dia, int mes, int anio){
        StringBuilder sb = new StringBuilder();
        if (dia < 10){
            sb.append("0"+dia);
        } else {
            sb.append(dia);
        }
        if (mes < 10){
            sb.append("/0"+mes);
        } else {
            sb.append("/"+mes);
        }
        sb.append("/"+anio);
        return sb.toString();

    }
}
