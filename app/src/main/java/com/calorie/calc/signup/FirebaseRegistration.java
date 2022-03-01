package com.calorie.calc.signup;

import android.content.Context;

import androidx.annotation.NonNull;

import com.calorie.calc.User;
import com.calorie.calc.signup.state.FirebaseAuthCompliteListener;
import com.calorie.calc.utils.UtilsLibrary;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseRegistration {

    FirebaseAuthCompliteListener listener;
    Context context;

    public FirebaseRegistration(Context context, FirebaseAuthCompliteListener listener) {
        this.listener = listener;
        this.context=context;

    }



    void createUserWithEmailAndPassword(User user)
    {

        if(!UtilsLibrary.isNetworkAvailable(context)){ listener.onStartLoad(false); return;}
        listener.onStartLoad(true);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                listener.onComplete();
              }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                System.out.println("onCanceled" );
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("onFailure" +e.getMessage()+e.getLocalizedMessage());
             listener.onFailure(e);
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                System.out.println("onSuccess"+authResult.getUser().toString() );
              listener.onSuccess(authResult);
            }
        });

    }
    void signInWithEmailAndPass(User user)
    {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        System.out.println("signInWithEmailAndPassuser"+user.getEmail() );
        System.out.println("signInWithEmailAndPassuseaaaar"+user.getPassword() );
        firebaseAuth.signInWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                listener.onComplete();
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                System.out.println("onCanceledSignIn" );
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                listener.onSuccess(authResult);
            }
        });
    }
    void rememberPass(String email )
    {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email ).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                listener.onComplete();
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                System.out.println("onCanceledSignIn" );
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onFailure(e);
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                listener.onSuccess(null);
            }
        });
    }
}
