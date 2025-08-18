class Train {
    String tcode;
    String train_name;
    int seat;
    int booked;
    double depart_time;
    String depart_place;

    public Train() {
    }

    public Train(String tcode, String train_name, int seat, int booked, double depart_time, String depart_place) {
        this.tcode = tcode;
        this.train_name = train_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    public int availableSeats() {
        return seat - booked;
    }

    @Override
    public String toString() {
        return tcode + " | " + train_name + " | " + seat + " | " + booked + " | " + depart_time + " | " + depart_place + " | " + availableSeats();
    }
}
