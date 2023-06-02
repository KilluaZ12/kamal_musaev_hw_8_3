package com.example.kamal_musaev_hw_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonPanel2 = requireActivity().findViewById<Button>(R.id.buttonPanel2)
        buttonPanel2.setOnClickListener {
            onClick()
        }
    }

    fun onClick() {

        val firstAnswer = view?.findViewById<EditText>(R.id.edit_text_first_answer)
        val secondAnswer = view?.findViewById<EditText>(R.id.edit_text_second_answer)
        val passportInn = view?.findViewById<EditText>(R.id.edit_text_passport_inn)

        val numberArray = arrayOf(100, 200, 300)
        val stringArray = arrayOf("apple", "honey", "fire", "maple")

        val inputAnswer = firstAnswer?.text.toString().toIntOrNull()
        val inputSecondAnswer = secondAnswer?.text.toString()
        val inputInn = passportInn?.text.toString()

        val numberExists = numberArray.contains(inputAnswer)
        val stringExists = stringArray.contains(inputSecondAnswer)
        val thirdLengthValid = inputInn.length >= 16

        if (numberExists && stringExists && thirdLengthValid) {
            val fragment = SecondBottomSheetFragment()
            fragment.show(parentFragmentManager, fragment.tag)
        } else {
            val fragment2 = ExampleBottomSheetFragment()
            fragment2.show(parentFragmentManager, fragment2.tag)

        }
    }
}