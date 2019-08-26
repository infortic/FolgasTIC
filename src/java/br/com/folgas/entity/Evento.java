package br.com.folgas.entity;

public class Evento {

    private Integer id;
    private String title;
    private String color;
    private String start_event;
    private String end_event;
    private String data_agendamento;
    private Colaborador colaborador = new Colaborador();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStart_event() {
        return start_event;
    }

    public void setStart_event(String start_event) {
        this.start_event = start_event;
    }

    public String getEnd_event() {
        return end_event;
    }

    public void setEnd_event(String end_event) {
        this.end_event = end_event;
    }

    public String getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

}
