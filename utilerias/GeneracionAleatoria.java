package utilerias;

import java.util.Random;

public final class GeneracionAleatoria {

    private static final Random RND = new Random();

    private static final String[] DIAGNOSTICOS = {
        "Infección respiratoria leve",
        "Cuadro alérgico cutáneo",
        "Deshidratación moderada",
        "Gastroenteritis aguda",
        "Otitis externa",
        "Dermatitis por pulgas",
        "Fractura simple en pata trasera",
        "Conjuntivitis bacteriana",
        "Parasitosis intestinal",
        "Desnutrición leve",
        "Cancer cervical",
        "Crisis de los cuarenta",
        "Diarrea explosiva",
        "Esquizofrenia",
        "Cólicos",
        "Hemorroides",
        "Sindrome de protafonista",
        "Cleptomanía",
        "Moquillo",
        "Intoxicación"
    };

    private static final String[] TRATAMIENTOS = {
        "Antibiótico oral cada 12 h por 7 días",
        "Dieta blanda y abundante agua por 5 días",
        "Suero intravenoso y observación 24 h",
        "Antihistamínico diario por 10 días",
        "Gotas óticas cada 8 h por 5 días",
        "Baño medicado y antipulgas",
        "Inmovilización con venda y reposo 3 semanas",
        "Colirio antibiótico cada 6 h por 7 días",
        "Desparasitante oral dosis única",
        "Suplemento vitamínico diario por 15 días",
        "Eutanasia",
        "Vacaciones en Veracruz durante 10 años",
        "Encerrar y olvidar la llave",
        "Prender incienso cada 12 horas durante 2 semanas",
        "Castrar",
        "Rapar y poner un cono",
        "Colonoscopia urgente",
        "Lavado de estomago"
    };

    private static final String[] OBSERVACIONES = {
        "Paciente estable, control en 5 días.",
        "Se recomienda análisis de sangre de control.",
        "Dueño reporta mejoría parcial al salir.",
        "Regresar de inmediato si presenta vómito.",
        "Mantener en reposo y evitar contacto con otros animales.",
        "Aplicar tratamiento estrictamente según indicaciones.",
        "Programar revisión en 10 días.",
        "Recomendable cambio de alimentación.",
        "Observar apetito y comportamiento durante la semana.",
        "Sin complicaciones aparentes al momento del alta.",
        "La mascota vomitó al becario.",
        "El termómetro de mercurio se rompió mientras se le media la temperatura a la mascota.",
        "La recepcionista se desmayo por lo feo que estaba la mascota",
        "La mascota mató a otra que salia de su tratamiento intensivo",
        "La mascota escapó",
        "La mascota defecó en toda la área de revisión."
    };

    public static String diagnostico() {
        return DIAGNOSTICOS[RND.nextInt(DIAGNOSTICOS.length)];
    }

    public static String tratamiento() {
        return TRATAMIENTOS[RND.nextInt(TRATAMIENTOS.length)];
    }

    public static String observacion() {
        return OBSERVACIONES[RND.nextInt(OBSERVACIONES.length)];
    }
}
