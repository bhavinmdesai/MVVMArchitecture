package dev.bhavindesai.mvvmarch.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {

    protected lateinit var baseViewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setObservers()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setObservers() {
        baseViewModel.errorMessage.observe(viewLifecycleOwner, Observer{
            AlertDialog
                .Builder(requireContext())
                .setTitle("Something went wrong")
                .setMessage(it)
                .setNegativeButton("Close") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                .show()
        })
    }

    protected fun showToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    protected fun showSnackBar(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    protected fun showPersistentSnackBar(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).show()
    }

    protected fun hideKeyboard() {
        val imm = requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        var view = requireActivity().currentFocus

        if (view == null) {
            view = View(requireContext())
        }

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    abstract fun onReAppear()
}