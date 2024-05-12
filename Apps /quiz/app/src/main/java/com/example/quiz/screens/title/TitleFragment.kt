
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quiz.R
import com.example.quiz.databinding.FragmentTitleBinding





class TitleFragment : Fragment() {
    lateinit var binding: FragmentTitleBinding
    lateinit var et_name: EditText
    lateinit var btn_start: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.startBtn.setOnClickListener { view: View ->

            if (binding.etName.text!!.isNotEmpty()) {
                view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
            } else {
                Toast.makeText(context, "Enter your name to start", Toast.LENGTH_SHORT).show()
            }
        }


        return  binding.root


    }


}
