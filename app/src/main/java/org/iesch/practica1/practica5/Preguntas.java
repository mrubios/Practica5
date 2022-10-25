package org.iesch.practica1.practica5;

public class Preguntas {
    int numero;
    String pregunta;
    String respuestaCorrecta;
    String respuestaIncorrecta;

    public Preguntas(int numero, String pregunta, String respuestaCorrecta, String respuestaIncorrecta) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaIncorrecta = respuestaIncorrecta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta() {
        return respuestaIncorrecta;
    }

    public void setRespuestaIncorrecta(String respuestaIncorrecta) {
        this.respuestaIncorrecta = respuestaIncorrecta;
    }
}
