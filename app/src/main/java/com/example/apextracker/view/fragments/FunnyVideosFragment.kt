package com.example.apextracker.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentFunnyVideosBinding
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.viewmodel.FunyVideosViewModel

class FunnyVideosFragment : Fragment() {

    private lateinit var funyVideosViewModel: FunyVideosViewModel
    private var _binding: FragmentFunnyVideosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        funyVideosViewModel =
            ViewModelProvider(this).get(FunyVideosViewModel::class.java)

        _binding = FragmentFunnyVideosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        funyVideosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
     //   inflater.inflate(R.menu.menu_profile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_profile -> {
                startActivity(Intent(requireActivity(), ProfileActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}