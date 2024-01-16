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
import com.mnashat_dev.zkatelebel.databinding.FragmentCamleBinding
import com.mnashat_dev.zkatelebel.databinding.FragmentCowsBinding


class CowsFragment : Fragment() {



    private lateinit var binding: FragmentCowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cows, container, false)
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
                    if (number >60) {
                        Toast.makeText(
                            activity,
                            "من فضلك أدخل رقم أقل من 61",
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
            in 0..29 -> setText(getString(R.string.no_zakat), " ")
            in 30..39 -> setText(
                getString(R.string.cow_30_39),
                getString(R.string.desc_cow_30_39)
            )
            in 40..59 -> setText(
                getString(R.string.cow_40_59),
                getString(R.string.desc_cow_40_59)
            )
           60 -> setText(
                getString(R.string.cow_60),
                getString(R.string.desc_cow_30_39)
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