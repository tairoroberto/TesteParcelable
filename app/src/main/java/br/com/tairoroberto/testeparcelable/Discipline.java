package br.com.tairoroberto.testeparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tairo on 12/01/15.
 */
public class Discipline implements Parcelable{
    private long id;
    private String name;

    public Discipline(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Discipline(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
    }

    //Obs: Obrigatorio usar o CREATOR para recuperar os dados do parcelable
    public static final Creator<Discipline> CREATOR = new Creator<Discipline>() {

        //Pega o nosso parcel e instacia para podermos utilizar o nosso objeto "No caso o Discipline"
        @Override
        public Discipline createFromParcel(Parcel source) {
            return new Discipline(source);
        }

        @Override
        public Discipline[] newArray(int size) {
            return new Discipline[size];
        }
    };
}
