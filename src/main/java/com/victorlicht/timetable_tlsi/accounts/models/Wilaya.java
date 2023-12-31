package com.victorlicht.timetable_tlsi.accounts.models;

import lombok.Getter;

@Getter
public enum Wilaya {
    ADRAR(1),
    CHLEF(2),
    LAGHOUAT(3),
    OUM_EL_BOUAGHI(4),
    BATNA(5),
    BEJAIA(6),
    BISKRA(7),
    BECHAR(8),
    BLIDA(9),
    BOUIRA(10),
    TAMANRASSET(11),
    TEBESSA(12),
    TLEMCEN(13),
    TIARET(14),
    TIZI_OUZOU(15),
    ALGIERS(16),
    DJELFA(17),
    JIJEL(18),
    SETIF(19),
    SAIDA(20),
    SKIKDA(21),
    SIDI_BEL_ABBES(22),
    ANNABA(23),
    GUELMA(24),
    CONSTANTINE(25),
    MEDEA(26),
    MOSTAGANEM(27),
    MSILA(28),
    MASCARA(29),
    OUARGLA(30),
    ORAN(31),
    EL_BAYADH(32),
    ILLIZI(33),
    BORDJ_BOU_ARRERIDJ(34),
    BOUMERDES(35),
    EL_TARF(36),
    TINDOUF(37),
    TISSEMSILT(38),
    EL_OUED(39),
    KHEMIS_MILIANA(40),
    SOUK_AHRAS(41),
    TIPAZA(42),
    MILA(43),
    AIN_DEFLA(44),
    NAAMA(45),
    AIN_TEMOUCHENT(46),
    GHARDAIA(47),
    RELIZANE(48),
    TIMIMOUN(49),
    BORDJ_BADJI_MOKHTAR(50),
    OULED_DJELLAL(51),
    BENI_ABBES(52),
    AIN_SALAH(53),
    AIN_GUEZZAM(54),
    TOUGGOURT(55),
    DJANET(56),
    EL_MGHAIR(57),
    EL_MENIA(58);

    private final int number;

    Wilaya(int number) {
        this.number = number;
    }
}

