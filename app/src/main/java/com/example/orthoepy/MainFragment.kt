package com.example.orthoepy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var bottomNavigationView: BottomNavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dictionaryFragment = DictionaryFragment()
        val teachingFragment = TeachingFragment()
        val profileFragment = ProfileFragment()
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        requireFragmentManager().beginTransaction().apply {
            replace(R.id.fragmentPlace, dictionaryFragment)
                .commit()
        }
        bottomNavigationView?.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.dictionary -> selectFragment(dictionaryFragment)
                R.id.teach -> selectFragment(teachingFragment)
                R.id.profile -> selectFragment(profileFragment)
            }
            true
        }
    }

    private fun selectFragment(fragment: Fragment){
        requireFragmentManager().beginTransaction().apply {
            replace(R.id.fragmentPlace, fragment)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}