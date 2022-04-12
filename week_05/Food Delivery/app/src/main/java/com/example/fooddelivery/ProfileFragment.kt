package com.example.fooddelivery

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentProfileBinding


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


        binding.btnLogout.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_profileFragment_to_welcomeFragment3)
        }
        binding.btnBack.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_profileFragment_to_restaurantFragment)

        }
        binding.editProfile.setOnClickListener {
            showDialog()
        }

    }

    private fun infolayout() {
        binding.editUsername.text = DataAccount.getAccountInfo().name
        binding.edtEmail.text = DataAccount.getAccountInfo().email
        binding.editTextPhone.text = DataAccount.getAccountInfo().phone
        binding.tvUserName.text = binding.editUsername.text
    }




    private fun showDialog() {

        val layoutDialog : View = LayoutInflater.from(requireContext()).inflate(R.layout.layout_dialog, null)
        val textName = layoutDialog.findViewById<EditText>(R.id.textFullName)
        textName.setText(binding.editUsername.text.toString())
        val textEmail = layoutDialog.findViewById<EditText>(R.id.textEmail)
        textEmail.setText(binding.edtEmail.text.toString())
        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.textPhoneNumber)
        textPhoneNumber.setText(binding.editTextPhone.text.toString())

        val builder = AlertDialog.Builder(requireContext())
            .setView(layoutDialog)
            .setTitle("Edit Information")

        builder.apply {
            setPositiveButton("Change", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
               // viewModel.checkEmail(textEmail.text.toString())

//                listenerSuccessEvent(textName.text.toString(),
//                    textEmail.text.toString(),
//                    textPhoneNumber.text.toString()
//                )
//                listenerErrorEvent()
//                DataAccount.editAccount(textName,)
//                infolayout()

            })
            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->

            })
        }
        builder.show()
    }

//    private fun listenerSuccessEvent(name: String, email:String, phone:String) {
//        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSucess ->
//            if (isSucess) {
//
//            }
//        }
////        UserManager.USER_EMAIL_KEY = email
////        UserManager.USER_NAME_KEY = name
////        UserManager.USER_PHONE_KEY = phone
//    }
    //AlertDialog.Builder(this)
//    private fun listenerErrorEvent() {
//        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
//            val dialog = AlertDialog.Builder(requireContext())
//            dialog.setTitle("Lỗi")
//            dialog.setMessage(errMsg)
//            dialog.show()
//        }
//    }

}