package br.com.engdb.agv.model;

public class Cliente {
    private final long id;
    private final String content;

    public Cliente(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
