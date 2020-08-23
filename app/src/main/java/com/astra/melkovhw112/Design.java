package com.astra.melkovhw112;

public class Design {
    private String header;
    private String content;

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public Design(String header, String content) {
        this.header = header;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", header, content);
    }
}
