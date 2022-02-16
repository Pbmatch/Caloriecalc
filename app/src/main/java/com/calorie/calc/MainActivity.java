package com.calorie.calc;

import static com.calorie.calc.NavigationHelper.openMainFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.calorie.calc.databinding.ActivityMainBinding;
import com.calorie.calc.signup.RegistrationActivity;
import com.calorie.calc.signup.state.RegStateHandler;
import com.calorie.calc.spoonacular.IngredientsApi;
import com.calorie.calc.spoonacular.client.model.InlineResponse20024;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        openMainFragment(getSupportFragmentManager());

        IngredientsApi apiInstance = new IngredientsApi();
        String query = burger; // String | The (natural language) search query.
        Integer number = 10; // Integer | The maximum number of items to return (between 1 and 100). Defaults to 10.
        Boolean metaInformation = false; // Boolean | Whether to return more meta information about the ingredients.
        String intolerances = egg; // String | A comma-separated list of intolerances. All recipes returned must not contain ingredients that are not suitable for people with the intolerances entered. See a full list of supported intolerances.
        try {
            List<InlineResponse20024> result = apiInstance.autocompleteIngredientSearch(query, number, metaInformation, intolerances);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IngredientsApi#autocompleteIngredientSearch");
            e.printStackTrace();
        }
      //  binding.bottomBar.setMenu();
     //   binding.bottomBar.getMenu().clear();
     //   binding.bottomBar.inflateMenu(R.menu.bottom_navigation);
//
        /* FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

      //  FirebaseAuth.getInstance().signOut();
       if(firebaseAuth.getCurrentUser()==null)
         {
             Intent mIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mIntent);
        }*/
    }



}