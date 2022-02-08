package com.calorie.calc.signup.state;

import com.google.firebase.auth.AuthResult;

public interface FirebaseAuthCompliteListener {
    void onStartLoad(Boolean start);
    void onComplete();
    void onFailure( Exception e);
    void onSuccess(AuthResult authResult);
}
