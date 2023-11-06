package com.example.educonn;
public class PerguntaFacil {

    public static String question[] = {
            "Quanto Ã© 2 + 2",
            "Quanto Ã© 34 + 16",
            "Quanto Ã© 5 - 2",
            "Quanto Ã© 57 - 17",
            "Quanto Ã© 2 x 3",
            "Quanto Ã© 72 x 2",
            "Quanto Ã© 6 / 2",
            "Quanto Ã© 36 / 9"
    };

    public static int choices[][] = {
            {3, 6, 4, 8},
            {50, 36, 54, 32},
            {4, 2, 3, 5},
            {24, 40, 56, 37},
            {4, 6, 8, 2},
            {124, 87, 100, 144},
            {4, 3, 2, 5},
            {4, 6, 2, 3}
    };

    public static int correctAnswer[] = {
            4,
            50,
            3,
            40,
            6,
            144,
            3,
            4
    };
}
