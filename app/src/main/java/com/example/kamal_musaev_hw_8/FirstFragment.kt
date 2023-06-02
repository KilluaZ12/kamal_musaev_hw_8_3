package com.example.kamal_musaev_hw_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonPanel = requireActivity().findViewById<Button>(R.id.buttonPanel)
        buttonPanel.setOnClickListener {
            onClick()
        }

    }

    fun onClick() {
        val editTextName = view?.findViewById<EditText>(R.id.edit_text_name)
        val editTextLastname = view?.findViewById<EditText>(R.id.edit_text_lastname)
        val editTextAge = view?.findViewById<EditText>(R.id.edit_text_age)
        val name = editTextName?.text.toString().trim()
        val lastname = editTextLastname?.text.toString().trim()
        val ageText = editTextAge?.text.toString().trim()

        if (!name.isEmpty() || !ageText.isEmpty() || !lastname.isEmpty()) {
            val age = ageText.toIntOrNull()

            if (age != null && age >= 18) {

                requireActivity().findViewById<Button>(R.id.buttonPanel).setOnClickListener {


                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                }
            } else {
                val fragment = ExampleBottomSheetFragment()
                fragment.show(parentFragmentManager, fragment.tag)
            }
        } else {
            Toast.makeText(requireContext(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT)
                .show()


        }
    }

}