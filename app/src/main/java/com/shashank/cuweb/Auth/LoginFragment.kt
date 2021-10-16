package com.shashank.cuweb.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.shashank.cuweb.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {
     private  lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        mAuth= FirebaseAuth.getInstance()



        view.button2.setOnClickListener {
            login()
        }


        return  view



    }

    private  fun login(){

        if(!editTextCheck(emailEdt)){

        }else if(!editTextCheck(passEdt)){

        }else{

            mAuth.signInWithEmailAndPassword(emailEdt.text.toString(),passEdt.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(activity, "Login Done", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }else{
                        Toast.makeText(activity, ""+it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }


        }




    }

    fun editTextCheck(editText: EditText):Boolean{


        if(editText.text.toString() == "") {
            Toast.makeText(
                requireContext(),
                "" + editText.hint.toString() + " is Empty",
                Toast.LENGTH_SHORT
            ).show()

            return false
        }
        return true

    }

}