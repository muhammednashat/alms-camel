package com.mnashat_dev.zkatelebel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mnashat_dev.zkatelebel.databinding.FragmentCowsBinding
import com.mnashat_dev.zkatelebel.databinding.FragmentGoatsBinding


class GoatsFragment : Fragment() {
    private lateinit var binding: FragmentGoatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goats, container, false)
        setUpEditText()
        return binding.root
    }

    private fun setUpEditText() {

        val textWatcher: TextWatcher = object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (s.isNotEmpty()) {
                    val number = s.toString().toInt()
                    if (number > 400) {
                        Toast.makeText(
                            activity,
                            "من فضلك أدخل رقم أقل من 401",
                            Toast.LENGTH_SHORT
                        ).show()
                        hideView(false)
                        return
                    } else {
                        calculateZkat(number)
                    }

                } else hideView(false)
            }
        }

        binding.editTextNumber.addTextChangedListener(textWatcher)
    }

    private fun calculateZkat(s: Int) {
        when (s) {
            in 0..39 -> setText(getString(R.string.no_zakat), " ")

            in 40..120 -> setText(
                getString(R.string.goat_40_120),
                getString(R.string.desc_goat_40_120)
            )
            in 121..200 -> setText(
                getString(R.string.goat_121_200),
                getString(R.string.desc_goat_121_400)
            )
            in 201..399 -> setText(
                getString(R.string.goat_201_399),
                getString(R.string.desc_goat_121_400)
            )
             400 -> setText(
                getString(R.string.goat_400),
                 getString(R.string.desc_goat_121_400)
            )





        }

        hideView(true)

    }

    private fun hideView(isHide: Boolean) {
        if (isHide) {
            binding.tvTitle.visibility = View.VISIBLE
            binding.tvNumberOfCamel.visibility = View.VISIBLE
            binding.tvExplanation.visibility = View.VISIBLE
        } else {
            binding.tvTitle.visibility = View.GONE
            binding.tvNumberOfCamel.visibility = View.GONE
            binding.tvExplanation.visibility = View.GONE
        }

    }

    private fun setText(number: String, explation: String) {
        binding.tvNumberOfCamel.text = number
        binding.tvExplanation.text = explation
    }
}