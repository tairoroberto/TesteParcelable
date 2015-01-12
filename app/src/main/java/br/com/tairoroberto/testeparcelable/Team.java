package br.com.tairoroberto.testeparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tairo on 12/01/15.
 */
public class Team implements Parcelable{
    private String name;
    private int qtdMembers;

    public Team(String name, int qtdMembers) {
        this.name = name;
        this.qtdMembers = qtdMembers;
    }

    public Team(Parcel parcel) {
        this.name = parcel.readString();
        this.qtdMembers = parcel.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtdMembers() {
        return qtdMembers;
    }

    public void setQtdMembers(int qtdMembers) {
        this.qtdMembers = qtdMembers;
    }

    //Pega o nosso parcel e instacia para podermos utilizar o nosso objeto "No caso o Team"
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(qtdMembers);
    }

    //Obs: Obrigatorio usar o CREATOR para recuperar os dados do parcelable
    public static final Creator<Team> CREATOR = new Creator<Team>() {

        //Pega o nosso parcel e instacia para podermos utilizar o nosso objeto "No caso o Team"
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
