package utilerias;

import java.util.Random;

/**
 * Genera cadenas aleatorias para diagnósticos, tratamientos y observaciones.
 *PD: ahi lo tunean esto, las cosas que pone son producto de la IA, las ponen más chispa
 */
public final class GeneracionAleatoria {

    private static final Random RND = new Random();

    // ---------- DATOS SEMILLA (ampliar libremente) ----------
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
        "Desnutrición leve"
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
        "Suplemento vitamínico diario por 15 días"
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
        "Sin complicaciones aparentes al momento del alta."
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
