package com.mnashat_dev.zkatelebel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mnashat_dev.zkatelebel.databinding.FragmentCamleBinding
import com.mnashat_dev.zkatelebel.databinding.FragmentChoosenBinding


class CamelFragment : Fragment() {

    private lateinit var binding: FragmentCamleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_camle, container, false)
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
                    if (number > 120) {
                        Toast.makeText(
                            activity,
                            "من فضلك أدخل رقم أقل من 120",
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
            in 0..4 -> setText(getString(R.string.oneToFour), " ")
            in 5..9 -> setText(
                getString(R.string.fifeToNine),
                getString(R.string.explFifeToTwentyFive)
            )
            in 10..14 -> setText(
                getString(R.string.tenToFourteen),
                getString(R.string.explFifeToTwentyFive)
            )
            in 15..19 -> setText(
                getString(R.string.fifteenToNineteen),
                getString(R.string.explFifeToTwentyFive)
            )
            in 20..25 -> setText(
                getString(R.string.twentyToTwentyFive),
                getString(R.string.explFifeToTwentyFive)
            )
            in 26..35 -> setText(
                getString(R.string.twentySixToThirtyFive),
                getString(R.string.explTwentySixToThirtyFive)
            )
            in 36..45 -> setText(
                getString(R.string.thirtySixToFortyFive),
                getString(R.string.explThirtySixToFortyFive)
            )
            in 46..60 -> setText(
                getString(R.string.fortySixToSixty),
                getString(R.string.explFortySixToSixty)
            )
            in 61..75 -> setText(
                getString(R.string.sixtyOneToSeventyFive),
                getString(R.string.explSixtyOneToSeventyFive)
            )
            in 76..90 -> setText(
                getString(R.string.seventySixToNinety),
                getString(R.string.explThirtySixToFortyFive)
            )
            in 91..120 -> setText(
                getString(R.string.ninetyOneToOneHundredAndTwenty),
                getString(R.string.explFortySixToSixty)
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