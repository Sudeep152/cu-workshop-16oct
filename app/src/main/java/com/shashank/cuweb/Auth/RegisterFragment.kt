package com.shashank.cuweb.Auth

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.shashank.cuweb.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {


    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth= FirebaseAuth.getInstance()
        val view =  inflater.inflate(R.layout.fragment_register, container, false)

         view.signUpBtn.setOnClickListener {
             Signup()
         }

        view.textView2.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }


        return  view;
    }


    private  fun Signup(){

        if(!editTextCheck(emailEdt)){

        }else if (!editTextCheck(passEdt)){

        }else if(!editTextCheck(repassEdt)){

        }else if(passEdt.text.toString() != repassEdt.text.toString()){
            Toast.makeText(
                requireContext(),
                "Please enter same pass",
                Toast.LENGTH_SHORT
            ).show()

        }
        else{
            auth.createUserWithEmailAndPassword(emailEdt.text.toString(),passEdt.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(activity," Sign up Done",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity,""+it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
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