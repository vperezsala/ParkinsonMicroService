package entities;

public class Compatible {
    private int patient;
    private boolean levodopaCompatible;
    private boolean dopamineAgonistCompatible;
    private boolean mao_b_Compatible;
    private boolean dbs_Compatible;
    public Compatible(){
        this.dopamineAgonistCompatible = true;
        this.levodopaCompatible = true;
        this.mao_b_Compatible = true;
        this.dbs_Compatible = true;
    }

    public Compatible(int patient){
        this.patient = patient;
        this.dopamineAgonistCompatible = true;
        this.levodopaCompatible = true;
        this.mao_b_Compatible = true;
        this.dbs_Compatible = true;
    }


    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public boolean isLevodopaCompatible() {
        return levodopaCompatible;
    }

    public void setLevodopaCompatible(boolean levodopaCompatible) {
        this.levodopaCompatible = levodopaCompatible;
    }

    public boolean isDopamineAgonistCompatible() {
        return dopamineAgonistCompatible;
    }

    public void setDopamineAgonistCompatible(boolean dopamineAgonistCompatible) {
        this.dopamineAgonistCompatible = dopamineAgonistCompatible;
    }

    public boolean isMao_b_Compatible() {
        return mao_b_Compatible;
    }

    public void setMao_b_Compatible(boolean mao_b_Compatible) {
        this.mao_b_Compatible = mao_b_Compatible;
    }

    public boolean isDbs_Compatible() {
        return dbs_Compatible;
    }

    public void setDbs_Compatible(boolean dbs_Compatible) {
        this.dbs_Compatible = dbs_Compatible;
    }

    @Override
    public String toString() {
        return "Compatible{" +
                "patient=" + patient +
                ", levodopaCompatible=" + levodopaCompatible +
                ", DopamineAgonistsCompatible=" + dopamineAgonistCompatible +
                ", mao_b_Compatible=" + mao_b_Compatible +
                '}';
    }
}
