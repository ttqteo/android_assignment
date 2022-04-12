package com.example.fooddelivery

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentProfileBinding
import com.example.fooddelivery.DataAccount


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infolayout()

    }

    private fun infolayout() {
        binding.editUsername.text = DataAccount.getAccountInfo().name
        binding.edtEmail.text = DataAccount.getAccountInfo().email
        binding.editTextPhone.text = DataAccount.getAccountInfo().phone
        binding.editUsername.text = binding.editUsername.text
    }




//    private fun showDialog() {
//
//        val layoutDialog : View = LayoutInflater.from(requireContext()).inflate(R.layout.layout_dialog, null)
//        val textName = layoutDialog.findViewById<EditText>(R.id.textFullName)
//        textName.setText(binding.editUsername.text.toString())
//        val textEmail = layoutDialog.findViewById<EditText>(R.id.textEmail)
//        textEmail.setText(binding.edtEmail.text.toString())
//        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.textPhoneNumber)
//        textPhoneNumber.setText(binding.editTextPhone.text.toString())
//
//        val builder = AlertDialog.Builder(requireContext())
//            .setView(layoutDialog)
//            .setTitle("Edit Information")
//
//        builder.apply {
//            setPositiveButton("Change", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
//                viewModel.checkEmail(textEmail.text.toString())
//                listenerSuccessEvent(textName.text.toString(),
//                    textEmail.text.toString(),
//                    textPhoneNumber.text.toString()
//                )
//                listenerErrorEvent()
//            })
//            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
//
//            })
//        }
//        builder.show()
//    }
//
//    private fun listenerSuccessEvent(name: String, email:String, phone:String) {
//        viewModel.isSuccessEvent.observe(this) { isSucess ->
//            if (isSucess) {
//                binding.user = com.example.fooddelivery.User(name, email, phone)
//            }
//        }
//        UserManager.USER_EMAIL_KEY = email
//        UserManager.USER_NAME_KEY = name
//        UserManager.USER_PHONE_KEY = phone
//    }
//    //AlertDialog.Builder(this)
//    private fun listenerErrorEvent() {
//        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
//            val dialog = AlertDialog.Builder(requireContext())
//            dialog.setTitle("Lỗi")
//            dialog.setMessage(errMsg)
//            dialog.show()
//        }
//    }




}