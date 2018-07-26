package com.example.lunar.criminalent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeSingleton {
    private static CrimeSingleton sCrimeLab;
    private List<Crime> mCrimes;
    public static CrimeSingleton get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeSingleton(context);
        }
        return sCrimeLab;
    }
    private CrimeSingleton(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Для каждого второго объекта
            mCrimes.add(crime);
        }
    }    public List<Crime> getCrimes() {
        return mCrimes;
    }
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}